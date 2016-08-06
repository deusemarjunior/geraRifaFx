package sample;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    List<ColunasNumeros> listColunaNumeros = new ArrayList<ColunasNumeros>();

    Integer controle = 1;
    Integer controleInterno= 1;

    /*****
     * 1 ate 333 - 3 = 330 (Ficam 3 fora que seriam da 14 pagina)
     *
     * 331 ate 663
     *
     * 664 ate 996
     *
     * @return
     */

    public List<ColunasNumeros> gerarSequencias(){

        Integer col1 = 1 , col2 = 331, col3 = 664;

        listColunaNumeros.add(new ColunasNumeros(col1,col2,col3));
        for (controle = 1; controle <333 ; controle ++){
            listColunaNumeros.add(new ColunasNumeros(col1+controle,col2+controle,col3+controle));
        }


        for (ColunasNumeros listColunaNumero : listColunaNumeros) {
            System.out.println("Lista --> " +listColunaNumero.getColuna1() +
                                      " - " +listColunaNumero.getColuna2() +
                                      " - " +listColunaNumero.getColuna3());
        }
        return listColunaNumeros;
    }

    public static void main(String[] args) {
        Controller controller  = new Controller();
        controller.gerarSequencias();
    }


}
