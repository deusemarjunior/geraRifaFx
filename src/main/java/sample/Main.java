package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.File;
import java.util.*;

public class Main extends Application {

    private Stage primaryStage;


    @FXML
    Label mensagemLabel = new Label();

    @FXML
    TextField tituloField = new TextField();
    @FXML
    TextField descricaoField = new TextField();
    @FXML
    TextField valorField = new TextField();


    @FXML
    DatePicker dataRifa = new DatePicker();

    @FXML
    Button btnGerarRifa = new Button();

    @FXML
    ChoiceBox qtdDezenas = new ChoiceBox();



    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
        primaryStage.setTitle("Gerador de Rifa Loteria Federal");
        primaryStage.setScene(new Scene(root, 650, 300));
        primaryStage.show();
        mensagemLabel.setText("");

    }

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        launch(args);
    }

    private boolean onValidateDoubleValue(String valorString){
        String valor = valorString.replaceAll(",",".");
        try {
            Double valorDouble = Double.parseDouble(valor);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void onGerarRifa(ActionEvent event){
       // System.out.println("Iniciou a Geração da Rifa");

           if(tituloField.getText() != null && !tituloField.getText().isEmpty()
                && descricaoField.getText() != null && !descricaoField.getText().isEmpty()
                && valorField.getText() != null && !valorField.getText().isEmpty()
                && qtdDezenas.getValue() != null
                && dataRifa.getValue() != null){

               mensagemLabel.setText("");

            if( onValidateDoubleValue(valorField.getText())) {

                Controller controller = new Controller();

                Stage dialog = new Stage();
                dialog.setResizable(true);
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(primaryStage);
                dialog.initStyle(StageStyle.UTILITY);

                HashMap<String, Object> parametros = new HashMap<String, Object>();

      //          System.out.println("Quantidade de dez " + qtdDezenas.getValue());

                parametros.put("TITULO", tituloField.getText());
                parametros.put("DESCRICAO", descricaoField.getText());
                parametros.put("VALOR", new Double(valorField.getText().replaceAll(",", ".")));
                //LocalDate _dataRifa = dataRifa.getValue();

                parametros.put("DATARIFA", DateUtils.asDate(dataRifa.getValue()));

                JasperPrint jasperPrint = null;

                List<String> listNumeros = controller.gerarSequencias(new Integer(qtdDezenas.getValue().toString()));
                try {
                    JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream("/rifa-10-por-pagina.jasper"));

                    jasperPrint = JasperFillManager.fillReport(jr, parametros,
                            new JRBeanCollectionDataSource(listNumeros));
                } catch (JRException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                listNumeros = null;

                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialFileName(String.format("Rifa-%s-%s.pdf", tituloField.getText(), Calendar.getInstance().getTimeInMillis()));
                fileChooser.setTitle("Salvar Rifa");

                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Document", Arrays.asList("*.pdf", "*.PDF")));
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Document", Arrays.asList("*.html", "*.HTML")));

                File file = fileChooser.showSaveDialog(dialog);
                if (fileChooser.getSelectedExtensionFilter() != null && fileChooser.getSelectedExtensionFilter().getExtensions() != null) {
                    java.util.List<String> selectedExtension = fileChooser.getSelectedExtensionFilter().getExtensions();
                    try {
                        if (selectedExtension.contains("*.pdf")) {
                            JasperExportManager.exportReportToPdfFile(jasperPrint, file.getAbsolutePath());
                        } else if (selectedExtension.contains("*.html")) {
                            JasperExportManager.exportReportToHtmlFile(jasperPrint, file.getAbsolutePath());
                        }
                    } catch (JRException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                mensagemLabel.setText("Digite um Valor Valido Ex 3,50");

            }

        }else{
            mensagemLabel.setText("Preencha os campos para gerar a Rifa.");
        }


    }

}
