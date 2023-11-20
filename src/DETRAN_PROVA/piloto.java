package DETRAN_PROVA;

public class piloto extends caroneiro{

    protected boolean embriagado;

    @Override
    public String toString() {
        return super.toString() + (isEmbriagado() ? ", EMBRIAGADO" : "");
    }

    public piloto() {
        super();
    }

    public piloto(String nome, int idade, char sexo, boolean vitimaFatal, boolean embriagado) {
        super(nome, idade, sexo, vitimaFatal);
        this.embriagado = embriagado;
    }

    public boolean isEmbriagado() {
        return embriagado;
    }
}
