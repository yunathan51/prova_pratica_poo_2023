package DETRANSC;

public class veiculoCarga extends veiculo {


    private int cargaCarregada;

    public veiculoCarga() {
        super();
    }

    public veiculoCarga(String marca, String modelo, int ano, TipoVeiculo tipoVeiculo, int cargaCarregada) {
        super(marca, modelo, ano, tipoVeiculo);
        this.cargaCarregada = cargaCarregada;
    }


    @Override
    public String toString() {
        String resultado = getTipoVeiculo() + " | " + getMarca() + " " + getModelo() + " " +
                getAno() + "\nCARGA CARREGADA: " + getCargaCarregada() + " KG" +"\n";

        for (condutor c : getCondutores()) {
            resultado += c.toString();
        }

        resultado += "Ocupantes:\n";


        if (getOcupantes().isEmpty()) {
            resultado += "Nenhum.\n";
        } else {

            for (pessoas ocupante : getOcupantes()) {
                resultado += ocupante.toString();
            }
        }

        return resultado;
    }

    public int getCargaCarregada() {
        return cargaCarregada;
    }

    public void setCargaCarregada(int cargaCarregada) {
        this.cargaCarregada = cargaCarregada;
    }
}


