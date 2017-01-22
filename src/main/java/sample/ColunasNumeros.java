package sample;

/**
 * Created by deusemarjunior on 06/08/16.
 */
public class ColunasNumeros {

    private Integer coluna1;
    private Integer coluna2;
    private Integer coluna3;


    private ColunasNumeros(){};

    public ColunasNumeros(Integer coluna1, Integer coluna2, Integer coluna3) {
        this.coluna1 = coluna1;
        this.coluna2 = coluna2;
        this.coluna3 = coluna3;
    }

    public Integer getColuna1() {
        return coluna1;
    }

    public void setColuna1(Integer coluna1) {
        this.coluna1 = coluna1;
    }

    public Integer getColuna2() {
        return coluna2;
    }

    public void setColuna2(Integer coluna2) {
        this.coluna2 = coluna2;
    }

    public Integer getColuna3() {
        return coluna3;
    }

    public void setColuna3(Integer coluna3) {
        this.coluna3 = coluna3;
    }
}
