package Examenes._17JunioRegata.Solucion;

import Examenes._17JunioRegata.Posicion;

import java.util.Arrays;

public class PruebaBarco {
    public static void main(String[] args) {
        Barco[] barcos = {
            new Barco("b3", new Posicion(0, 0), 0, 0),
            new Barco("b1", new Posicion(0, 0), 0, 0),
            new Barco("b4", new Posicion(0, 0), 0, 0),
            new Barco("b2", new Posicion(0, 0), 0, 0),
        };
        System.out.println("-- Barcos ordenados");
        Arrays.sort(barcos);
        for(Barco b : barcos){
            System.out.println(b);
        }
        System.out.println("\n-- Mayor/menor barco");
        System.out.printf("Menor barco: %s\n", barcos[0]);
        System.out.printf("Mayor barco: %s\n", barcos[barcos.length - 1]);
    }
}
