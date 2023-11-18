package DETRANSC;

import java.util.ArrayList;

public class pessoas {

    private String nome;
    private int idade;
    private char sexo;
    private boolean vitimaFatal;




    public pessoas () {
        this("", 0, ' ', false);
    }

    public pessoas(String nome, int idade, char sexo, boolean vitimaFatal) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.vitimaFatal = vitimaFatal;


    }



    @Override
    public String toString () {
        return getNome()+ ", " + " SEXO: " + getSexo() + ", " + " IDADE: " + getIdade() + (isVitimaFatal() ? ", FATAL" : "") + "\n";
    }











































    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public boolean isVitimaFatal() {
        return vitimaFatal;
    }

    public void setVitimaFatal(boolean vitimaFatal) {
        this.vitimaFatal = vitimaFatal;
    }



}
