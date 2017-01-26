package sample;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    List<String> numeros = new ArrayList<String>();

    Integer controle = 1;

    /*****
     * Para 3 dezenas
     *
     * 1 ate 333
     *
     * 334 ate 667
     *
     * 667 ate 999
     *
     * ====
     *
     * Para 2 Dezenas
     *
     * 1 até 499
     *
     * 500 até 999
     *
     * ===
     *
     * Para 1 Dezena 999
     *
     * @return List<Stirng></Stirng>
     */
    public List<String> gerarSequencias(Integer qtdDezenas){

        if(qtdDezenas == 3 ) {
            Integer col1 = 1, col2 = 334, col3 = 667;

            numeros.add(String.format("  %s     %s      %s ", col1, col2, col3));
            for (controle = 1; controle < 333; controle++) {
                numeros.add(String.format("  %s     %s      %s ",col1 + controle, col2 + controle, col3 + controle));
            }
        }
        if(qtdDezenas == 2){
            Integer col1 = 1, col2 = 500;

            numeros.add(String.format("   %s       %s  ", col1, col2));
            for (controle = 1; controle < 499; controle++) {
                if(controle == 498)
                    numeros.add(String.format("  %s     %s      %s ",col1 + controle, col2 + controle, 999));
                else
                    numeros.add(String.format("   %s       %s  ",col1 + controle, col2 + controle));

            }

        }
        if(qtdDezenas == 1){
            Integer col1 = 1;

            numeros.add(String.format("     %s      ", col1));
            for (controle = 1; controle < 999; controle++) {
                numeros.add(String.format("     %s      ",col1 + controle));
            }
        }

        /* teste para verificar a sequencia numerica
        for (String linha : numeros) {
           System.out.println(" Linha --> " + linha );
        }
        */
        return numeros;
    }

    public static void main(String[] args) {
        Controller controller  = new Controller();
        controller.gerarSequencias(2);
    }


}
