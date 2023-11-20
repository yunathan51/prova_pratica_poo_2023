package DETRAN_PROVA;

public class vehiclesCarga extends vehicles{

    protected int carga;

    @Override
    public String toString() {
        return super.toString() + "Carga: " + carga + "\n";
    }


    public vehiclesCarga(){
        this("", "", 0, TipoVeiculo.NAO_INFORMADO, 0);
    }

    public vehiclesCarga(String marca, String modelo, int ano, TipoVeiculo tipoVeiculo, int carga){
        super(marca, modelo, ano, tipoVeiculo);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }
}
