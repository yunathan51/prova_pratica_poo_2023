package DETRANSC;

import java.util.ArrayList;

public class DEBUG {

    public static void main(String[] args) {
        ArrayList<rodovias> estradas = new ArrayList<>();
        ArrayList<veiculo> veiculos = new ArrayList<>();
        ArrayList<acidentes> acidentes = new ArrayList<>();

        rodovias r1 = new rodovias("BR", 101, rodovias.Periculosidade.ALTO);
        rodovias r2 = new rodovias("SC", 390, rodovias.Periculosidade.ALTO);
        estradas.add(r1);
        estradas.add(r2);

        //--------------
        veiculo v1 = new veiculo("Fiat", "Uno", 2010, veiculo.TipoVeiculo.PASSEIO);

        veiculo v4 = new veiculoCarga("Ford", "Cargo", 2008, veiculo.TipoVeiculo.TRANSPORTE_CARGAS, 6500);

        veiculos.add(v1);

        veiculos.add(v4);

        //--------------
        pessoas p1 = new pessoas("João", 20, 'M', false);
        pessoas p2 = new pessoas("Maria", 25, 'F', true);

        condutor c1 = new condutor("Rafael", 30, 'M', true, true);
        condutor c2 = new condutor("Clavison", 35, 'M', false, true);

        v1.adicionarCondutores(c1);
        v1.adicionarOcupantes(p1);
        v1.adicionarOcupantes(p2);

        v4.adicionarCondutores(c2);
        v4.adicionarOcupantes(p1);
        v4.adicionarOcupantes(p2);


        acidentes a1 = new acidentes(1, r1);
        a1.adicionarVeiculoEnvolvido(v1);
        a1.adicionarVeiculoEnvolvido(v4);
        System.out.println(a1);


        acidentes a2 = new acidentes(2, r2);
        a2.adicionarVeiculoEnvolvido(v1);

        acidentes.add(a1);
        acidentes.add(a2);




        for (acidentes acidente: acidentes) {
            System.out.println(acidente.condutorDrunk(veiculos));
        }
        //System.out.println(acidentes.condutorDrunk(veiculos));





    }
}
