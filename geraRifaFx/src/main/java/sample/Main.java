package sample;

import com.javafx.tools.doclets.internal.toolkit.util.DocFinder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.List;

import java.util.ArrayList;

public class Main extends Application {

    Controller controller = new Controller();

    List<ColunasNumeros> colunasNumerosList = new ArrayList<ColunasNumeros>();

    Label tituloLabel = new Label("Título");
    Label descricaoLabel = new Label("Descrição");
    Label valorLabel = new Label("Valor");

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Gerador de Rifa Loteria Federal");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
