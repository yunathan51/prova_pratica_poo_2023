package DETRAN_PROVA;

import DETRANSC.veiculo;

import java.util.ArrayList;

public class vehicles {

    protected String marca;
    protected String modelo;
    protected int ano;
    protected TipoVeiculo tipoVeiculo;
    protected ArrayList<caroneiro> occupantes = new ArrayList<>();
    protected ArrayList<piloto> pilotos = new ArrayList<>();



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Veículo: ").append(marca).append(" ").append(modelo).append(" ").append(ano).append(" ").append(tipoVeiculo).append("\n");

        if (!pilotos.isEmpty()) {
            result.append("Condutor:\n").append(pilotos.get(0).toString() + "\n");
        }

        result.append("Passageiros:\n");
        for (caroneiro caroneiro : occupantes) {
            if (occupantes.isEmpty()) {
                result.append("Não há passageiros\n");
            } else {
            result.append(caroneiro.toString() + "\n");
        }
            }
        result.append("\n");

        return result.toString();
    }




















    public vehicles() {
        this("", "", 0, TipoVeiculo.NAO_INFORMADO);
    }

    public vehicles(String marca, String modelo, int ano, TipoVeiculo tipoVeiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.tipoVeiculo = tipoVeiculo;
    }

    protected enum TipoVeiculo {
        PASSEIO,
        BICICLETA,
        TRANSPORTE_CARGAS,
        NAO_INFORMADO;


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

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public ArrayList<caroneiro> getOccupants() {
        return occupantes;
    }

    public void setOccupants(ArrayList<caroneiro> occupants) {
        this.occupantes = occupants;
    }
}
