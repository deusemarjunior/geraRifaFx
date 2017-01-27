package sample;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    List<String> numeros = new ArrayList<String>();

    Integer controle = 1;

    /**
     * Retorna a lista de String para gerar a rifa
     *
     * 4 dezenas = concorre com 4 numeros por rifa
     *
     * 3 dezenas = concorre com 3 numeros por rifa
     *
     * 2 dezenas = concorre com 2 numeros por rifa
     *
     * 1 dezenas = concorre com 1 numeros por rifa
     *
     * @param qtdDezenas
     * @return
     */
    public List<String> gerarSequencias(Integer qtdDezenas){


        if(qtdDezenas == 4 ) {
            Integer col1 = 0, col2 = 250, col3 = 500 , col4 = 750;

            numeros.add(String.format("  %03d  -  %03d  -  %03d  -  %03d  ", col1 , col2, col3, col4));
            for (controle = 1; controle < 250; controle++) {
                numeros.add(String.format("  %03d  -  %03d  -  %03d  -  %03d  ",col1 + controle, col2 + controle, col3 + controle, col4 + controle));
            }
        }

        if(qtdDezenas == 3 ) {
            Integer col1 = 0, col2 = 333, col3 = 667;
            numeros.add(String.format("  %03d  -  %03d  -  %03d  ", col1, col2, col3));
            for (controle = 1; controle < 333; controle++) {
                numeros.add(String.format("  %03d  -  %03d  -  %03d  ",col1 + controle, col2 + controle, col3 + controle));
            }
        }
        if(qtdDezenas == 2){
            Integer col1 = 0, col2 = 500;

            numeros.add(String.format("  %03d  -  %03d  ", col1, col2));
            for (controle = 1; controle < 500; controle++) {
                  numeros.add(String.format("  %03d  -  %03d  ",col1 + controle, col2 + controle));
            }

        }
        if(qtdDezenas == 1){
            Integer col1 = 0;

            numeros.add(String.format("  %03d  ", col1));
            for (controle = 1; controle < 1000; controle++) {
                numeros.add(String.format("  %03d  ", col1 + controle));
            }
        }

        /* teste para verificar a sequencia numerica */
     /*   for (String linha : numeros) {
           System.out.println(" Linha --> " + linha );
        }
*/
        return numeros;
    }


    public static void main(String[] args) {
        Controller controller  = new Controller();
        controller.gerarSequencias(4);
    }


}
