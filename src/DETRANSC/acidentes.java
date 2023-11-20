package DETRANSC;

import java.util.ArrayList;

public class acidentes {

    private int mes;
    private rodovias rodovia;
    private ArrayList<veiculo> veiculosEnvolvidos = new ArrayList<>();
    private ArrayList<pessoas> vitimas = new ArrayList<>();

    public acidentes(int mes, rodovias rodovia) {
        this.mes = mes;
        this.rodovia = rodovia;
    }




    public void adicionarVeiculoEnvolvido(veiculo veiculo) {
        veiculosEnvolvidos.add(veiculo);
    }


    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Mês: ").append(mes).append("\n");
        resultado.append("Rodovia: ").append(rodovia.toString()).append("\n");
        resultado.append("Veículos Envolvidos:\n\n");

        for (veiculo veiculo : veiculosEnvolvidos) {
            resultado.append(veiculo.toString()).append("\n");
        }

        int totalVitimas = contarVitimas(veiculosEnvolvidos);
        int totalFeridos = contarFeridos(veiculosEnvolvidos);
        int totalFatais = contarFatais(veiculosEnvolvidos);

        resultado.append("Vítimas no Mês ").append(mes).append(": ").append(totalVitimas).append("\n");
        resultado.append("Feridos: ").append(totalFeridos).append("\n");
        resultado.append("Fatais: ").append(totalFatais).append("\n");

        return resultado.toString();
    }

    private int contarVitimas(ArrayList<veiculo> veiculos) {
        int totalVitimas = 0;
        for (veiculo veiculo : veiculos) {
            totalVitimas += veiculo.getOcupantes().size() + veiculo.getCondutores().size();
        }
        return totalVitimas;
    }

    private int contarFeridos(ArrayList<veiculo> veiculos) {
        int totalFeridos = 0;
        for (veiculo veiculo : veiculos) {
            for (pessoas ocupante : veiculo.getOcupantes()) {
                if (!ocupante.isVitimaFatal()) {
                    totalFeridos++;
                }
            }
            for (pessoas condutor : veiculo.getCondutores()) {
                if (!condutor.isVitimaFatal()) {
                    totalFeridos++;
                }
            }
        }
        return totalFeridos;
    }

    private int contarFatais(ArrayList<veiculo> veiculos) {
        int totalFatais = 0;
        for (veiculo veiculo : veiculos) {
            for (pessoas ocupante : veiculo.getOcupantes()) {
                if (ocupante.isVitimaFatal()) {
                    totalFatais++;
                }
            }
            for (condutor condutor : veiculo.getCondutores()) {
                if (condutor.isVitimaFatal()) {
                    totalFatais++;
                }
            }
        }
        return totalFatais;
    }

    public String condutorDrunk(ArrayList<veiculo> veiculos) {
        StringBuilder resultado = new StringBuilder();
        for (veiculo veiculo : veiculos) {
            for (condutor condutor : veiculo.getCondutores()) {
                if (condutor.isEmbriagado()) {
                    resultado.append(condutor);
                }
            }
        }
        return resultado.toString();
    }







}
