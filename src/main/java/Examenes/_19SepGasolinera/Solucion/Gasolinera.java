package Examenes._19SepGasolinera.Solucion;

import java.util.*;

public class Gasolinera {
    protected String nombre;
    protected int contador;
    private Map<String, List<Double>> surtidores;
    private Map<String, SortedSet<Ticket>> repostajes;
    private TicketOrdenAlternativo ordenAlternativo;

    // constantes de clase
    protected static final String GASOLINA95 = "gasolina95";
    protected static final String GASOLINA98 = "gasolina98";
    protected static final String DIESEL = "diesel";
    protected static final String DIESEL_PLUS = "dieselPlus";
    protected static final int NUM_SURT = 4;

    // constante de instancia
    protected final Map<String, Double> precios;

    public Gasolinera(String nom, Map<String, Double> precios, String fichero, TicketOrdenAlternativo orden){
        this.nombre = nom;
        this.contador = 1;
        this.repostajes = new HashMap<>();
        this.precios = precios;

        // 1. Se crea la correspondencia vacia
        this.surtidores = new HashMap<>();

        // 2. Se crean los surtidores añadiendo al diccionario tantas entradas como tipos de combustible hay
        // con una lista de tantos 0.0 como surtidores haya
        for(String tipo_combustible : precios.keySet()){
            this.surtidores.put(tipo_combustible, new ArrayList<>(NUM_SURT));
        }

        // 3.
    }
    public Gasolinera(String nom, Map<String, Double> precios, String fichero){
        this(nom, precios, fichero, null);
    }


}
