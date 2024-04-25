package Examenes._20JunioDados.Solucion;

import java.util.List;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("-- Juego A");
        JuegoA ja = new JuegoA(1, 6);
        List<Integer> expA = ja.experimento(30);
        SortedMap<Integer, Integer> expA_agrupados = ja.agrupa(expA);
        System.out.println(expA_agrupados);

        Estadistica estA = new Estadistica(expA_agrupados);
        System.out.println("Media = " + estA.media());
        System.out.println("Moda = " + estA.moda());
        System.out.println("Mediana = " + estA.mediana());

        System.out.println("-- Juego B");
        JuegoB jB = new JuegoB(3, 2);
        List<Integer> expB = jB.experimento(30);
        SortedMap<Integer, Integer> expB_agrupados = jB.agrupa(expB);
        System.out.println(expB_agrupados);

        Estadistica estB = new Estadistica(expB_agrupados);
        System.out.println("Media = " + estB.media());
        System.out.println("Moda = " + estB.moda());
        System.out.println("Mediana = " + estB.mediana());

    }
}
