package DETRAN_PROVA;

import java.util.ArrayList;

public class accidents {

    private int mes;
    private Estrada estrada;

    private ArrayList<vehicles> VeiculosAcidente = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(estrada.getSigla()).append(" - ").append(estrada.getKilometragem()).append(" PERIGO:" + estrada.getPericulosidade()).append("\n");
        result.append("Mes: ").append(mes).append("\n");


        for (vehicles veiculo : VeiculosAcidente) {
            result.append(veiculo.toString());
        }

        return result.toString();
    }

    public accidents(){
        this(0, null);
    }

    public accidents(int mes, Estrada estrada){
        this.mes = mes;
        this.estrada = estrada;
    }

    public void addVeiculosAcidente(vehicles veiculos) {
        VeiculosAcidente.add(veiculos);
    }

    public int getMes() {
        return mes;
    }
    public Estrada getEstrada() {
        return estrada;
    }
    public ArrayList<vehicles> getVeiculosAcidente() {
        return VeiculosAcidente;
    }

}
