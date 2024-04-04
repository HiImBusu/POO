package Examenes.Elecciones;

public class Test {
    public static void main(String[] args) {
        Candidata cand1 = new Candidata("MR. FANTÁSTICO", "123", Candidata.Sexo.M, "Los 4 Fantásticos");
        Candidata cand2 = new Candidata("ANTORCHA HUMANA", "321", Candidata.Sexo.M, "Los 4 Fantásticos");
        Candidata cand3 = new Candidata("MUJER INVISIBLE", "456", Candidata.Sexo.F, "Los 4 Fantásticos");
        Candidata cand4 = new Candidata("LA COSA", "654", Candidata.Sexo.M, "Los 4 Fantásticos");
        Candidata cand5 = new Candidata("SPIDERMAN", "789", Candidata.Sexo.M, "MARVEL");
        Candidata cand6 = new Candidata("BATMAN", "987", Candidata.Sexo.M, "DC COMICS");

        Candidatura c1 = new Candidatura("Los 4 Fantásticos", "NUEVA YORK");
        c1.agregarMiembro(cand2);
        c1.agregarMiembro(cand3);
        c1.agregarMiembro(cand4);
        c1.agregarCabezaLista(cand1);
        c1.agregarMiembro(cand5);
        c1.agregarMiembro(cand6);

        System.out.println(c1);


        Candidatura cP1 = new CandidaturaPartido("Los 4 Fantásticos", "NUEVA YORK");
        cP1.agregarMiembro(cand2);
        cP1.agregarMiembro(cand3);
        cP1.agregarMiembro(cand4);
        cP1.agregarCabezaLista(cand1);
        cP1.agregarMiembro(cand5);
        cP1.agregarMiembro(cand6);

        System.out.println(c1);


    }
}
