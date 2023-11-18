package DETRANSC;

public class rodovias {

    private String sigla;
    private int kilometragem;
    private Periculosidade periculosidade;


    public rodovias () {
        this("", 0, Periculosidade.NAO_DEFINIDO);
    }


    public rodovias(String sigla, int kilometragem, Periculosidade periculosidade) {
        this.sigla = sigla;
        this.kilometragem = kilometragem;
        this.periculosidade = periculosidade;
    }

    @Override
    public String toString() {
        return getSigla() + "-" + getKilometragem() + " PERIGO: " + getPericulosidade();
    }


    protected enum Periculosidade {
        NAO_DEFINIDO,
        BAIXO,
        MEDIO,
        ALTO;
    }

    boolean cadastrarRodovia(rodovias rodovia) {
        if (!getSigla().isEmpty() && getKilometragem() > 0 && getPericulosidade() != Periculosidade.NAO_DEFINIDO) {
            return true;
        }
        return false;
    }





    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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
