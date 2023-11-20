package DETRAN_PROVA;



public class Estrada {

    protected String Sigla;
    protected int kilometragem;
    protected Periculosidade periculosidade;


    @Override
    public String toString(){
        return getSigla() + "-" + getKilometragem() + " PERIGO: " + getPericulosidade();
    }


    public Estrada(){
        this("", 0, Periculosidade.NAO_DEFINIDO);
    }

    public Estrada(String Sigla, int kilometragem, Periculosidade periculosidade){
        this.Sigla = Sigla;
        this.kilometragem = kilometragem;
        this.periculosidade = periculosidade;
    }

    public enum Periculosidade{
        NAO_DEFINIDO,
        BAIXO,
        MEDIO,
        ALTO;


    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String sigla) {
        Sigla = sigla;
    }

    public int getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem;
    }

    public Periculosidade getPericulosidade() {
        return periculosidade;
    }

    public void setPericulosidade(Periculosidade periculosidade) {
        this.periculosidade = periculosidade;
    }

}
