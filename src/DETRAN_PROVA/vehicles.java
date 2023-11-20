package DETRAN_PROVA;

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










    public int getAno() {
        return ano;
    }
    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }
}
