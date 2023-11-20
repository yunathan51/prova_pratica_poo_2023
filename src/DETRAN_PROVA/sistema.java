package DETRAN_PROVA;

import java.util.ArrayList;

public class sistema {

    ArrayList<Estrada> roads = new ArrayList<>();
    ArrayList<vehicles> vehicles = new ArrayList<>();
    ArrayList<accidents> acidentes = new ArrayList<>();



    public void addRoad(String sigla, int kilometragem, Estrada.Periculosidade periculosidade) {
        Estrada estrada = new Estrada(sigla, kilometragem, periculosidade);
        roads.add(estrada);
    }

    public void addVehicle(String marca, String modelo, int ano, vehicles.TipoVeiculo tipoVeiculo) {
        vehicles vehicle = new vehicles(marca, modelo, ano, tipoVeiculo);
        vehicles.add(vehicle);
    }

    public void addVehicleCarga(String marca, String modelo, int ano, vehicles.TipoVeiculo tipoVeiculo, int capacidadeCarga) {
        vehiclesCarga vehicle = new vehiclesCarga(marca, modelo, ano, tipoVeiculo, capacidadeCarga);
        vehicles.add(vehicle);
    }

    public void addPiloto(vehicles veiculo, String nome, int idade, char sexo, boolean vitimaFatal, boolean embriagado) {
        piloto piloto = new piloto(nome, idade, sexo, vitimaFatal, embriagado);
        veiculo.pilotos.add(piloto);
    }


    public void addPassageiro(vehicles veiculo, String nome, int idade, char sexo, boolean vitimaFatal) {
        caroneiro caroneiro = new caroneiro(nome, idade, sexo, vitimaFatal);
        veiculo.occupantes.add(caroneiro);
    }

    public void addAcidente(int mes, Estrada estrada) {
        accidents acidente = new accidents(mes, estrada);
        acidentes.add(acidente);
    }

    public void addVeiculosAcidente(accidents acidente, vehicles veiculo) {
        acidente.addVeiculosAcidente(veiculo);
    }

    public void listarVeiculosComCondutorEmbriagado() {
        for (accidents acidente : acidentes) {
            for (vehicles veiculo : acidente.getVeiculosAcidente()) {
                for (piloto piloto : veiculo.pilotos) {
                    if (piloto.isEmbriagado()) {
                        StringBuilder result = new StringBuilder();
                        result.append("Mes: ").append(acidente.getMes()).append("\n");
                        result.append("Rodovia: ").append(acidente.getEstrada().getSigla()).append("-").append(acidente.getEstrada().getKilometragem()).append("\n");
                        result.append(veiculo.toString());
                        result.append("\n");
                        System.out.println(result.toString());
                    }
                }
            }
        }
    }

    public void listarVeiculosDeCargaAcidentados() {
        for (accidents acidente : acidentes) {
            for (vehicles veiculo : acidente.getVeiculosAcidente()) {
                if (veiculo.getTipoVeiculo() == DETRAN_PROVA.vehicles.TipoVeiculo.TRANSPORTE_CARGAS) {
                    StringBuilder result = new StringBuilder();
                    result.append("Mes: ").append(acidente.getMes()).append("\n");
                    result.append("Rodovia: ").append(acidente.getEstrada().getSigla()).append("-").append(acidente.getEstrada().getKilometragem()).append("\n");
                    result.append(veiculo.toString());
                    result.append("\n");
                    System.out.println(result.toString());
                }
            }
        }
    }

    private int contarAcidentesFatais(Estrada rodovia) {
        int numeroAcidentesFatais = 0;

        for (accidents acidente : acidentes) {
            if (acidente.getEstrada().equals(rodovia)) {
                for (vehicles veiculo : acidente.getVeiculosAcidente()) {
                    for (piloto piloto : veiculo.pilotos) {
                        if (piloto.isVitimaFatal()) {
                            numeroAcidentesFatais++;
                        }
                    }

                    for (caroneiro ocupante : veiculo.occupantes) {
                        if (ocupante.isVitimaFatal()) {
                            numeroAcidentesFatais++;
                        }
                    }
                }
            }
        }

        return numeroAcidentesFatais;
    }

    public void listarRodoviaMaisAcidentesFatais() {
        String rodoviaMaisAcidentes = "";
        int maiorNumeroAcidentesFatais = 0;

        for (Estrada rodovia : roads) {
            int numeroAcidentesFatais = contarAcidentesFatais(rodovia);
            if (numeroAcidentesFatais > maiorNumeroAcidentesFatais) {
                maiorNumeroAcidentesFatais = numeroAcidentesFatais;
                rodoviaMaisAcidentes = rodovia.getSigla();
            }
        }

        if (rodoviaMaisAcidentes != null) {
            System.out.println(rodoviaMaisAcidentes);

        }

    }

    public void listarAcidentesVeiculosAcima2013() {
        for (accidents acidente : acidentes) {
            for (vehicles veiculos : acidente.getVeiculosAcidente()) {
                if (veiculos.getAno() >= 2013) {
                    StringBuilder result = new StringBuilder();
                    result.append("Mes: ").append(acidente.getMes()).append("\n");
                    result.append("Rodovia: ").append(acidente.getEstrada().getSigla()).append("-").append(acidente.getEstrada().getKilometragem()).append("\n");
                    result.append(veiculos.toString());
                    result.append("\n");
                    System.out.println(result.toString());

                }
            }
        }


    }

    public void listarInformacoesRodovias() {
        for (Estrada rodovia : roads) {
            int totalAcidentes = contarAcidentes(rodovia);

            System.out.println(rodovia.getSigla() + " - " + rodovia.getKilometragem() + " | " +  rodovia.getPericulosidade());
            System.out.println("Acidentes: " + totalAcidentes);
            System.out.println();
        }
    }

    private int contarAcidentes(Estrada rodovia) {
        int totalAcidentes = 0;

        for (accidents acidente : acidentes) {
            if (acidente.getEstrada().equals(rodovia)) {
                totalAcidentes++;
            }
        }

        return totalAcidentes;
    }

    public void listarRodoviaComMaisAcidentesDeBicicleta() {
        String rodoviaMaisAcidentesBicicleta = "";
        int maiorNumeroAcidentesBicicleta = 0;

        for (Estrada rodovia : roads) {
            int numeroAcidentesBicicleta = contarAcidentesDeBicicleta(rodovia);
            if (numeroAcidentesBicicleta > maiorNumeroAcidentesBicicleta) {
                maiorNumeroAcidentesBicicleta = numeroAcidentesBicicleta;
                rodoviaMaisAcidentesBicicleta = rodovia.getSigla() + "-" + rodovia.getKilometragem() + " | " + rodovia.getPericulosidade();
            }
        }

        if (!rodoviaMaisAcidentesBicicleta.isEmpty()) {
            System.out.println(rodoviaMaisAcidentesBicicleta);
        } else {
            System.out.println("Nenhuma rodovia com acidentes de bicicleta encontrada.");
        }
    }

    private int contarAcidentesDeBicicleta(Estrada rodovia) {
        int numeroAcidentesBicicleta = 0;

        for (accidents acidente : acidentes) {
            if (acidente.getEstrada().equals(rodovia)) {
                for (vehicles veiculo : acidente.getVeiculosAcidente()) {
                    if (veiculo.getTipoVeiculo() == DETRAN_PROVA.vehicles.TipoVeiculo.BICICLETA) {
                        numeroAcidentesBicicleta++;
                    }
                }
            }
        }

        return numeroAcidentesBicicleta;
    }

    public void listarRodoviasComAcidentesEmFevereiro() {
        String acidenteCarnaval = "";

        for (accidents acidente : acidentes) {
            if (acidente.getMes() == 2) {
                Estrada rodovia = acidente.getEstrada();
                acidenteCarnaval = rodovia.getSigla() + " - " + rodovia.getKilometragem();
                System.out.println(acidenteCarnaval);
            }
        }
    }

}
