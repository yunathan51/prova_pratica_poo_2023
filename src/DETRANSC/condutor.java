package DETRANSC;

public class condutor extends pessoas {

    private boolean embriagado;

    @Override
    public String toString() {
        return getNome()+ ", " + " SEXO: " + getSexo() + ", " + " IDADE: " + getIdade() + (isVitimaFatal() ? ", FATAL" : "") +(isEmbriagado() ? ", EMBRIAGADO" : "") + "\n";
    }

    public condutor () {
        super();
    }

    public condutor(String nome, int idade, char sexo, boolean vitimaFatal, boolean embriagado) {
        super(nome, idade, sexo, vitimaFatal);
        this.embriagado = embriagado;
    }




















    public boolean isEmbriagado() {
        return embriagado;
    }

    public void setEmbriagado(boolean embriagado) {
        this.embriagado = embriagado;
    }
}
