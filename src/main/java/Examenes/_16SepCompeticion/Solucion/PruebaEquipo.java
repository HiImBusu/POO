package Examenes._16SepCompeticion.Solucion;

import java.util.SortedSet;
import java.util.TreeSet;

public class PruebaEquipo {
    public static void main(String[] args) {
        SortedSet<Equipo> conj = new TreeSet<>();
        conj.add(new Equipo("Parque Litoral", 3, 10));
        conj.add(new Equipo("Centro Padel", 2, 6));
        conj.add(new Equipo("Padel Palo", 3, 8));
        System.out.println(conj);

        SortedSet<Equipo> conj2 = new TreeSet<>(new OrdenAlternativoEquipo());
        conj2.add(new Equipo("Parque Litoral", 3, 10));
        conj2.add(new Equipo("Centro Padel", 2, 6));
        conj2.add(new Equipo("Padel Palo", 3, 8));
        System.out.println(conj2);
    }
}
