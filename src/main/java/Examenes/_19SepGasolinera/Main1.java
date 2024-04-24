package Examenes._19SepGasolinera;

import Examenes._19SepGasolinera.Solucion.Gasolinera;
import Examenes._19SepGasolinera.Solucion.TicketOrdenAlternativo;

import java.util.HashMap;
import java.util.Map;

public class Main1 {
    public static void main(String[] args) {
        Map<String, Double> precios = new HashMap<>();
        precios.put("gasolina95", 1.755);
        precios.put("gasolina98", 1.918);
        precios.put("diesel", 1.608);
        precios.put("dieselPlus", 1.703);

        System.out.println("-- Estado inicial de la gasolinera");
        Gasolinera g = new Gasolinera("Teatinos", precios, "src\\main\\java\\Examenes\\_19SepGasolinera\\surtidores.txt", new TicketOrdenAlternativo());
        System.out.println(g);

        System.out.println("\n-- Añadimos algunos repostajes");
        g.repostar("1111AAA", Gasolinera.GASOLINA95, 1, 50);
        g.repostar("1111AAA", Gasolinera.GASOLINA95, 2, 50);
        g.repostar("2222BBB", Gasolinera.GASOLINA95, 1, 20);
        g.repostar("2222BBB", Gasolinera.GASOLINA95, 3, 10);
        g.repostar("3333BBB", Gasolinera.DIESEL, 2, 50);
        g.repostar("3333BBB", Gasolinera.DIESEL, 1, 30);
        System.out.println(g);

        System.out.println("\n-- Generamos algun ticket");
        g.facturar("1111AAA");
        System.out.println("Ticket 1111AAA generado correctamente");

        System.out.println("\n-- Le metemos algun ticket mas");
        g.repostar("1111AAA", Gasolinera.GASOLINA95, 3, 5);
        System.out.println(g);

        System.out.println("\n-- Comprobamos que le hemos facturado correctamente sus tickets");
        System.out.printf("Consumo facturado por la matricula 1111AAA: %.2f", g.obtenerConsumoFacturado("1111AAA"));

    }
}
