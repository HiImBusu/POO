package Examenes._16SepCompeticion;

import Examenes._16SepCompeticion.Solucion.Jugador;

public class PruebaJugador {
    public static void main(String[] args) {
        Jugador j1 = new Jugador("Ana Romero", 2, 1);
        Jugador j2 = new Jugador("ana romero", 2, 0);
        j2.increPartidos(1, 1);
        System.out.printf("Jugador 1 = %s\n", j1);
        System.out.printf("Jugador 2 = %s\n", j2);
        if(j1.equals(j2)){
            System.out.println("Los jugadores son iguales");
        }else{
            System.out.println("Los jugadores son distintos");
        }
    }
}
