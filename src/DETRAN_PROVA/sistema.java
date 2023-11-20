package DETRAN_PROVA;

import java.util.ArrayList;

public class sistema {

    ArrayList<Estrada> roads = new ArrayList<>();
    ArrayList<vehicles> vehicles = new ArrayList<>();
    ArrayList<accidents> acidentes = new ArrayList<>();
    ArrayList<sistema> BancoDados = new ArrayList<>();



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

    public void addPiloto(vehicles veiculo, String nome, int idade, char sexo, boolean vitimaFatal, boolean embriagado){
        piloto piloto = new piloto(nome, idade, sexo, vitimaFatal, embriagado);
        veiculo.pilotos.add(piloto);
    }


    public  void addPassageiro(vehicles veiculo, String nome, int idade, char sexo, boolean vitimaFatal){
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

}
