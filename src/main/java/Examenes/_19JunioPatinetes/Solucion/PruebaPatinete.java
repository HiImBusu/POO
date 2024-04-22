package Examenes._19JunioPatinetes.Solucion;

import Examenes._19JunioPatinetes.Posicion;

import java.util.SortedSet;
import java.util.TreeSet;

public class PruebaPatinete {
    public static void main(String[] args) {
        try {
            Patinete p1 = new Patinete("Campero", 100, new Posicion(-4.4204216, 36.7182771), 3.0);
            Patinete p2 = new Patinete("campero", 100, new Posicion(-4.4495993, 36.7015323), 2.0);
            Patinete p3 = new Patinete("Biznaga", 101, new Posicion(-4.4150382, 36.7306184), 5.0);
            System.out.printf("Patinete 1: %s\n", p1);
            System.out.printf("Patinete 2: %s\n", p2);
            System.out.printf("Patinete 3: %s\n", p3);

            if(p1.equals(p2)){
                System.out.println("Los patinetes 1 y 2 son iguales");
            }else{
                System.out.println("Los patinetes 1 y 2 NO son iguales");
            }
            SortedSet<Patinete> conj = new TreeSet<>();
            conj.add(p1);
            conj.add(p2);
            conj.add(p3);
            System.out.printf("Conjunto: %s\n", conj);

            p3.setAutonomia(-7);

        } catch (PatinetesException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
    }



}
