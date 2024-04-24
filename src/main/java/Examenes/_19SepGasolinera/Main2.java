package Examenes._19SepGasolinera;

import Examenes._19SepGasolinera.Solucion.Gasolinera;
import Examenes._19SepGasolinera.Solucion.GasolineraPromocion;
import Examenes._19SepGasolinera.Solucion.TicketOrdenAlternativo;

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        Map<String, Double> precios = new HashMap<>();
        precios.put("gasolina95", 1.755);
        precios.put("gasolina98", 1.918);
        precios.put("diesel", 1.608);
        precios.put("dieselPlus", 1.703);

        System.out.println("-- Estado inicial de la gasolinera");
        Gasolinera g = new GasolineraPromocion("TeatinosPROMO", precios, "src\\main\\java\\Examenes\\_19SepGasolinera\\surtidores.txt", new TicketOrdenAlternativo());
        System.out.println(g);

        System.out.println("\n-- Añadimos algunos repostajes");
        // ticket sin promocion ninguna
        g.repostar("5555DDD", Gasolinera.DIESEL, 1, 120);
        g.facturar("5555DDD");
        // ticket con promocion 1
        g.repostar("5555DDD", Gasolinera.DIESEL, 2, 200);
        g.facturar("5555DDD");
        // ticket con promocion 2
        g.repostar("5555DDD", Gasolinera.DIESEL, 3, 50);
        g.facturar("5555DDD");
        System.out.println(g);
    }
}
