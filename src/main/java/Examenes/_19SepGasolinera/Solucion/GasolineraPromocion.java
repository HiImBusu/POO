package Examenes._19SepGasolinera.Solucion;

import java.util.Map;

public class GasolineraPromocion extends Gasolinera{
    public static final int CONSUMO_MINIMO1 = 100;
    public static final int CONSUMO_MINIMO2 = 300;
    public static final double DESCUENTO1 = 0.10;
    public static final double DESCUENTO2 = 0.30;

    public GasolineraPromocion(String nom, Map<String, Double> precios, String fichero, TicketOrdenAlternativo orden){
        super(nom, precios, fichero, orden);
    }
    public GasolineraPromocion(String nom, Map<String, Double> precios, String fichero){
        super(nom, precios, fichero);
    }

    @Override
    protected Ticket crearTicket(String matricula, double litros, double precio_litro) {
        // 1. Calcular el consumo total previo
        double consumo_actual = super.obtenerConsumoFacturado(matricula);

        // 2. Si el consumo facturado es < CONSUMO_MINIMO1 no se aplica descuento
        // si esta entre [CONSUMO_MINIMO1, CONSUMO_MINIMO2] aplicar DESCUENTO1
        // si es superior a CONSUMO_MINIMO2 aplicar DESCUENTO2
        Ticket t;
        if(consumo_actual < CONSUMO_MINIMO1){
            t = new Ticket(contador, nombre, matricula, litros, precio_litro);
        }else if(consumo_actual < CONSUMO_MINIMO2){
            t = new TicketPromocion(contador, nombre, matricula, litros, precio_litro, DESCUENTO1);
        }else{
            t = new TicketPromocion(contador, nombre, matricula, litros, precio_litro, DESCUENTO2);
        }
        contador++;
        return t;
    }
}
