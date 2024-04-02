package Examenes.Formula1;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Monoplaza m = new Monoplaza(55, "Carlos Sainz", "Ferrari", TipoRueda.C3, new Motor("Ferrari", 0.8, 600));
        System.out.println("-- Creamos un monoplaza");
        System.out.println(m);

        System.out.println("\n-- Simulamos varias vueltas a un circuito");
        int nVueltas = 44;
        Random rnd = new Random();
        for (int i = 1; i <= nVueltas; i++) {
            m.incVuelta(90, 0.95, rnd);
            System.out.println(String.format("[%d] %s", i, m));
        }
    }
}
