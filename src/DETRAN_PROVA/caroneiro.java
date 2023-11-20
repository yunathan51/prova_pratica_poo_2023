package DETRAN_PROVA;

public class caroneiro {

    private String nome;
    private int idade;
    private char sexo;
    private boolean vitimaFatal;

    @Override
    public String toString() {
        return getNome()+ ", " + " SEXO: " + getSexo() + ", " + " IDADE: " + getIdade() + (isVitimaFatal() ? ", FATAL" : "");
    }

    public caroneiro() {
        this("", 0, ' ', false);
    }

    public caroneiro(String nome, int idade, char sexo, boolean vitimaFatal) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.vitimaFatal = vitimaFatal;
    }

    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public char getSexo() {
        return sexo;
    }
    public boolean isVitimaFatal() {
        return vitimaFatal;
    }

}
