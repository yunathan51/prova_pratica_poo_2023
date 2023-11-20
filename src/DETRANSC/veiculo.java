package DETRANSC;

import java.util.ArrayList;

public class veiculo {

    private String marca;
    private String modelo;
    private int ano;
    private TipoVeiculo tipoVeiculo;
    private ArrayList<pessoas> ocupantes = new ArrayList<>();
    private ArrayList<condutor> condutores = new ArrayList<>();
    private ArrayList<rodovias> rodovias = new ArrayList<>();







    public String toString() {
        String resultado = getTipoVeiculo() + " | " + getMarca() + " " + getModelo() + " " +
                getAno() + "\n";


        for (condutor c : getCondutores()) {
            resultado += c.toString();
        }

        resultado += "Ocupantes:\n";


        if (getOcupantes().isEmpty()) {
            resultado += "Nenhum.\n";
        } else {

            for (pessoas ocupante : getOcupantes()) {
                resultado += ocupante.toString() + "";
            }
        }

        return resultado;
    }










    public veiculo() {
        this("", "", 0, TipoVeiculo.NAO_DEFINIDO);
    }






    public veiculo(String marca, String modelo, int ano, TipoVeiculo tipoVeiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.tipoVeiculo = tipoVeiculo;
    }






    protected enum TipoVeiculo {
        PASSEIO,
        BICICLETA,
        MOTOCICLETA,
        TRANSPORTE_PESSOAS,
        TRANSPORTE_CARGAS,
        NAO_DEFINIDO;


    }








    boolean adicionarOcupantes(pessoas ocupante) {
        getOcupantes().add(ocupante);
        return true;
    }

    boolean adicionarCondutores(condutor condutor) {
        if (getCondutores().isEmpty()) {
            getCondutores().add(condutor);
            return true;
        }
        return false;
    }

























    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public ArrayList<pessoas> getOcupantes() {
        return ocupantes;
    }

    public void setOcupantes(ArrayList<pessoas> ocupantes) {
        this.ocupantes = ocupantes;
    }

    public veiculo.TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(veiculo.TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public ArrayList<DETRANSC.condutor> getCondutores() {
        return condutores;
    }

    public void setCondutores(ArrayList<DETRANSC.condutor> condutores) {
        this.condutores = condutores;
    }

    public ArrayList<DETRANSC.rodovias> getRodovias() {
        return rodovias;
    }

    public void setRodovias(ArrayList<DETRANSC.rodovias> rodovias) {
        this.rodovias = rodovias;
    }



}
