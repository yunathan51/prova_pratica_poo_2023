package DETRAN_PROVA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class sistemaTest {

    sistema sistema;

    @BeforeEach
    void executaAntes() {
        sistema = new sistema();

    }

    @Test
    void addRoadTest() {
        sistema.addRoad("SC", 100, Estrada.Periculosidade.ALTO);
        assertEquals("SC", sistema.roads.get(0).getSigla());
        assertEquals(100, sistema.roads.get(0).getKilometragem());
        assertEquals(Estrada.Periculosidade.ALTO, sistema.roads.get(0).getPericulosidade());

    }

    @Test
    void addVehicleTest() {
        sistema.addVehicle("Fiat", "Uno", 2010, vehicles.TipoVeiculo.PASSEIO);
        assertEquals("Fiat", sistema.vehicles.get(0).getMarca());
        assertEquals("Uno", sistema.vehicles.get(0).getModelo());
        assertEquals(2010, sistema.vehicles.get(0).getAno());
        assertEquals(vehicles.TipoVeiculo.PASSEIO, sistema.vehicles.get(0).getTipoVeiculo());
    }

    @Test
    void addVehicleCargaTest() {
        sistema.addVehicleCarga("Fiat", "Strada", 2013, vehicles.TipoVeiculo.TRANSPORTE_CARGAS, 100);
        assertEquals("Fiat", sistema.vehicles.get(0).getMarca());
        assertEquals("Strada", sistema.vehicles.get(0).getModelo());
        assertEquals(2013, sistema.vehicles.get(0).getAno());
        assertEquals(vehicles.TipoVeiculo.TRANSPORTE_CARGAS, sistema.vehicles.get(0).getTipoVeiculo());
        assertEquals(100, ((vehiclesCarga) sistema.vehicles.get(0)).getCarga());
    }

    @Test
    void addPilotoTest() {
        sistema.addVehicle("Fiat", "Uno", 2010, vehicles.TipoVeiculo.PASSEIO);
        sistema.addPiloto(sistema.vehicles.get(0), "Joao", 20, 'M', false, true);


        assertEquals("Joao", sistema.vehicles.get(0).pilotos.get(0).getNome());
        assertEquals(20, sistema.vehicles.get(0).pilotos.get(0).getIdade());
        assertEquals('M', sistema.vehicles.get(0).pilotos.get(0).getSexo());
        assertFalse(sistema.vehicles.get(0).pilotos.get(0).isVitimaFatal());
        assertTrue(sistema.vehicles.get(0).pilotos.get(0).isEmbriagado());
    }

    @Test
    void addPassageiroTest() {
        sistema.addVehicle("Fiat", "Uno", 2010, vehicles.TipoVeiculo.PASSEIO);
        sistema.addPassageiro(sistema.vehicles.get(0), "Joao", 20, 'M', false);
        assertEquals("Joao", sistema.vehicles.get(0).occupantes.get(0).getNome());
        assertEquals(20, sistema.vehicles.get(0).occupantes.get(0).getIdade());
        assertEquals('M', sistema.vehicles.get(0).occupantes.get(0).getSexo());
        assertFalse(sistema.vehicles.get(0).occupantes.get(0).isVitimaFatal());
    }

    @Test
    void addAcidenteTest() {
        sistema.addRoad("SC", 100, Estrada.Periculosidade.ALTO);
        sistema.addAcidente(1, sistema.roads.get(0));
        assertEquals(1, sistema.acidentes.get(0).getMes());
        assertEquals(sistema.roads.get(0), sistema.acidentes.get(0).getEstrada());
    }

    @Test
    void addVeiculosAcidenteTest() {
        sistema.addRoad("SC", 100, Estrada.Periculosidade.ALTO);
        sistema.addVehicle("Fiat", "Uno", 2010, vehicles.TipoVeiculo.PASSEIO);
        sistema.addAcidente(1, sistema.roads.get(0));
        sistema.addVeiculosAcidente(sistema.acidentes.get(0), sistema.vehicles.get(0));
        assertEquals(sistema.vehicles.get(0), sistema.acidentes.get(0).getVeiculosAcidente().get(0));
    }

    @Test
    void listarVeiculosComCondutorEmbriagadoTest() {
        sistema.addRoad("SC", 100, Estrada.Periculosidade.ALTO);
        sistema.addVehicle("Fiat", "Uno", 2010, vehicles.TipoVeiculo.PASSEIO);
        sistema.addPiloto(sistema.vehicles.get(0), "Joao", 20, 'M', false, true);
        sistema.listarVeiculosComCondutorEmbriagado();
        assertTrue(sistema.vehicles.get(0).pilotos.get(0).isEmbriagado());

    }

    @Test
    void listarVeiculosDeCargaAcidentadosTest() {
        sistema.addRoad("SC", 100, Estrada.Periculosidade.ALTO);
        sistema.addVehicleCarga("Fiat", "Strada", 2013, vehicles.TipoVeiculo.TRANSPORTE_CARGAS, 100);
        sistema.addAcidente(1, sistema.roads.get(0));
        sistema.addVeiculosAcidente(sistema.acidentes.get(0), sistema.vehicles.get(0));
        sistema.listarVeiculosDeCargaAcidentados();
        assertEquals(vehicles.TipoVeiculo.TRANSPORTE_CARGAS, sistema.vehicles.get(0).getTipoVeiculo());
    }

    @Test
    void listarRodoviaMaisAcidentesFataisTest() {
        sistema.addRoad("SC", 100, Estrada.Periculosidade.ALTO);
        sistema.addRoad("PR", 100, Estrada.Periculosidade.ALTO);

        sistema.addVehicle("Fiat", "Uno", 2010, vehicles.TipoVeiculo.PASSEIO);
        sistema.addPiloto(sistema.vehicles.get(0), "Joao", 20, 'M', true, true);

        sistema.addAcidente(1, sistema.roads.get(0));

        sistema.listarRodoviaMaisAcidentesFatais();
        assertEquals("SC", sistema.roads.get(0).getSigla());
        assertEquals(100, sistema.roads.get(0).getKilometragem());
        assertEquals(Estrada.Periculosidade.ALTO, sistema.roads.get(0).getPericulosidade());

    }

    @Test
    void listarAcidentesVeiculosAcima2013Test() {
        sistema.addRoad("SC", 100, Estrada.Periculosidade.ALTO);
        sistema.addVehicle("Fiat", "Uno", 2010, vehicles.TipoVeiculo.PASSEIO);
        sistema.addVehicle("Fiat", "Uno", 2013, vehicles.TipoVeiculo.PASSEIO);
        sistema.addAcidente(1, sistema.roads.get(0));
        sistema.addVeiculosAcidente(sistema.acidentes.get(0), sistema.vehicles.get(0));
        sistema.addVeiculosAcidente(sistema.acidentes.get(0), sistema.vehicles.get(1));
        sistema.listarAcidentesVeiculosAcima2013();
        assertEquals(2013, sistema.vehicles.get(1).getAno());
        assertEquals(vehicles.TipoVeiculo.PASSEIO, sistema.vehicles.get(1).getTipoVeiculo());

    }

    @Test
    void listarInformacoesRodoviasTest() {
        sistema.addRoad("SC", 100, Estrada.Periculosidade.ALTO);
        sistema.addRoad("PR", 100, Estrada.Periculosidade.ALTO);
        sistema.addRoad("RS", 100, Estrada.Periculosidade.ALTO);
        sistema.addAcidente(1, sistema.roads.get(0));
        sistema.addAcidente(1, sistema.roads.get(0));
        sistema.listarInformacoesRodovias();
        assertEquals("SC", sistema.roads.get(0).getSigla());
        assertEquals(100, sistema.roads.get(0).getKilometragem());
        assertEquals(Estrada.Periculosidade.ALTO, sistema.roads.get(0).getPericulosidade());

    }

    @Test
    void listarRodoviaComMaisAcidentesDeBicicletaTest() {
        sistema.addVehicle("Caloi", "CaloiDaora", 2023, vehicles.TipoVeiculo.BICICLETA);

        sistema.addRoad("SC", 100, Estrada.Periculosidade.ALTO);
        sistema.addRoad("BR", 157, Estrada.Periculosidade.ALTO);
        sistema.addAcidente(1, sistema.roads.get(0));
        sistema.addVeiculosAcidente(sistema.acidentes.get(0), sistema.vehicles.get(0));
        sistema.listarRodoviaComMaisAcidentesDeBicicleta();
        assertEquals("SC", sistema.roads.get(0).getSigla());
        assertEquals(100, sistema.roads.get(0).getKilometragem());
        assertEquals(Estrada.Periculosidade.ALTO, sistema.roads.get(0).getPericulosidade());
    }

    @Test
    void listarRodoviasComAcidentesEmFevereiroTest() {
        sistema.addRoad("SC", 100, Estrada.Periculosidade.ALTO);
        sistema.addAcidente(2, sistema.roads.get(0));
        sistema.listarRodoviasComAcidentesEmFevereiro();
        assertEquals("SC", sistema.roads.get(0).getSigla());
        assertEquals(100, sistema.roads.get(0).getKilometragem());
        assertEquals(Estrada.Periculosidade.ALTO, sistema.roads.get(0).getPericulosidade());

    }

    @Test
    void adicionarPilotoAoCarro() {
        sistema.addVehicle("Fiat", "Uno", 2010, vehicles.TipoVeiculo.PASSEIO);
        sistema.addPiloto(sistema.vehicles.get(0), "Joao", 20, 'M', false, true);
        assertEquals("Joao", sistema.vehicles.get(0).pilotos.get(0).getNome());
        assertEquals(20, sistema.vehicles.get(0).pilotos.get(0).getIdade());
        assertEquals('M', sistema.vehicles.get(0).pilotos.get(0).getSexo());
        assertFalse(sistema.vehicles.get(0).pilotos.get(0).isVitimaFatal());
        assertTrue(sistema.vehicles.get(0).pilotos.get(0).isEmbriagado());

    }

    @Test
    void construtorVazioAccidents() {
        accidents acidente = new accidents();
        assertEquals(0, acidente.getMes());
        assertNull(acidente.getEstrada());
    }

    @Test
    void construtorVazioEstrada() {
        Estrada estrada = new Estrada();
        assertEquals("", estrada.getSigla());
        assertEquals(0, estrada.getKilometragem());
        assertEquals(Estrada.Periculosidade.NAO_DEFINIDO, estrada.getPericulosidade());
    }

    @Test
    void construtorVazioPiloto() {
        piloto piloto = new piloto();
        assertEquals("", piloto.getNome());
        assertEquals(0, piloto.getIdade());
        assertEquals(' ', piloto.getSexo());
        assertFalse(piloto.isVitimaFatal());
        assertFalse(piloto.isEmbriagado());
    }

    @Test
    void construtorVazioVeiculos() {
        vehicles veiculo = new vehicles();
        assertEquals("", veiculo.getMarca());
        assertEquals("", veiculo.getModelo());
        assertEquals(0, veiculo.getAno());
        assertEquals(vehicles.TipoVeiculo.NAO_INFORMADO, veiculo.getTipoVeiculo());
    }








}