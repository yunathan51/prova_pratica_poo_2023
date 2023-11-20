package DETRAN_PROVA;

public class Util {
    public static void main(String[] args) {
        sistema sistema = new sistema();

        sistema.addRoad("A", 100, Estrada.Periculosidade.BAIXO);
        sistema.addRoad("B", 200, Estrada.Periculosidade.MEDIO);
        sistema.addRoad("C", 300, Estrada.Periculosidade.ALTO);

        sistema.addVehicle("Fiat", "Uno", 2010, vehicles.TipoVeiculo.PASSEIO);
        sistema.addVehicleCarga("Fiat", "Strada", 2013, vehicles.TipoVeiculo.TRANSPORTE_CARGAS, 100);

        sistema.addPiloto(sistema.vehicles.get(1), "Joao", 20, 'M', false, true);
        sistema.addPassageiro(sistema.vehicles.get(1), "Maria", 20, 'F', false);



        sistema.addPiloto(sistema.vehicles.get(0), "Kaike", 20, 'M', false, true);
        sistema.addPassageiro(sistema.vehicles.get(0), "Joao", 20, 'M', true);
        sistema.addPassageiro(sistema.vehicles.get(0), "Maria", 20, 'F', false);
        sistema.addPassageiro(sistema.vehicles.get(0), "Jose", 20, 'M', false);
        sistema.addPassageiro(sistema.vehicles.get(0), "Joana", 20, 'F', false);
        sistema.addPassageiro(sistema.vehicles.get(0), "Pedro", 20, 'M', false);


        sistema.addAcidente(1, sistema.roads.get(0));
        sistema.addVeiculosAcidente(sistema.acidentes.get(0), sistema.vehicles.get(0));
        sistema.addVeiculosAcidente(sistema.acidentes.get(0), sistema.vehicles.get(1));

        sistema.addAcidente(2, sistema.roads.get(1));
        sistema.addVeiculosAcidente(sistema.acidentes.get(1), sistema.vehicles.get(0));
        sistema.addVehicle("Fiat", "Uno", 2010, vehicles.TipoVeiculo.BICICLETA);
        sistema.addVeiculosAcidente(sistema.acidentes.get(1), sistema.vehicles.get(2));


        System.out.println(sistema.acidentes.get(0).toString());


        sistema.listarVeiculosComCondutorEmbriagado();
        sistema.listarVeiculosDeCargaAcidentados();
        sistema.listarRodoviaMaisAcidentesFatais();
        sistema.listarAcidentesVeiculosAcima2013();
        sistema.listarInformacoesRodovias();
        sistema.listarRodoviaComMaisAcidentesDeBicicleta();
        sistema.listarRodoviasComAcidentesEmFevereiro();


    }
}
