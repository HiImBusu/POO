package Examenes._19SepGasolinera.Solucion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class Gasolinera {
    protected String nombre;
    protected int contador;
    private Map<String, List<Double>> surtidores;
    private Map<String, SortedSet<Ticket>> repostajes;
    private TicketOrdenAlternativo ordenAlternativo;

    // constantes de clase
    public static final String GASOLINA95 = "gasolina95";
    public static final String GASOLINA98 = "gasolina98";
    public static final String DIESEL = "diesel";
    public static final String DIESEL_PLUS = "dieselPlus";
    protected static final int NUM_SURT = 4;

    // constante de instancia
    protected final Map<String, Double> precios;

    public Gasolinera(String nom, Map<String, Double> precios, String fichero, TicketOrdenAlternativo orden){
        this.nombre = nom;
        this.contador = 1;
        this.repostajes = new HashMap<>();
        this.precios = precios;
        this.ordenAlternativo = orden;

        // 1. Se crea la correspondencia vacia
        this.surtidores = new HashMap<>();

        // 2. Se crean los surtidores añadiendo al diccionario tantas entradas como tipos de combustible hay
        // con una lista de tantos 0.0 como surtidores haya
        for(String tipo_combustible : precios.keySet()){
            this.surtidores.put(tipo_combustible, new ArrayList<>());
        }

        // 2.1. Para cada entrada meter tantos surtidores como NUM_SURT con el valor 0.0
        for(String tipo_combustible : this.surtidores.keySet()){
            for(int surt = 1; surt <= NUM_SURT; surt++){
                this.surtidores.get(tipo_combustible).add(0.0);
            }
        }

        // 3. Se completa la informacion de los surtidores con los datos del fichero "surtidores.txt".
        // 1 gasolina95 56.0
        cargarFichero(fichero);
    }
    public Gasolinera(String nom, Map<String, Double> precios, String fichero){
        this(nom, precios, fichero, null);
    }

    private void cargarFichero(String fichero){
        try (Scanner sc = new Scanner(Path.of(fichero))){
            while(sc.hasNextLine()){
                procesar(sc.nextLine());
            }
        }catch (IOException ex){
            throw new GasolineraException("No se ha podido abrir el fichero");
        }
    }
    private void procesar(String linea){
        try(Scanner sc = new Scanner(linea);){
            // Uso delimitador el espacio
            sc.useDelimiter("[ ]");

            // Para especificar los decimales con el punto
            sc.useLocale(Locale.ENGLISH);

            int numero_surtidor = sc.nextInt();
            String tipo_gasolina = sc.next();
            double litros = sc.nextDouble();

            // Inserto el dato en el diccionario
            List<Double> surtidor = this.surtidores.get(tipo_gasolina);
            if(surtidor == null)
                throw new GasolineraException("No se encuentra el surtidor de gasolina: " + tipo_gasolina);

            surtidor.set(numero_surtidor - 1, surtidor.get(numero_surtidor - 1) + litros);
        }catch (InputMismatchException ex){
            throw new GasolineraException("Error de formato en linea: " + linea);
        }
    }


    public void repostar(String matricula, String tipo_combustible, int surtidor, double litros){
        if(surtidor <= 0 || surtidor > NUM_SURT)
            throw new GasolineraException("Numero de surtidor no valido");
        if(!tipo_combustible.equalsIgnoreCase(GASOLINA95) &&
                !tipo_combustible.equalsIgnoreCase(GASOLINA98) &&
                !tipo_combustible.equalsIgnoreCase(DIESEL) &&
                !tipo_combustible.equalsIgnoreCase(DIESEL_PLUS)
        )
            throw new GasolineraException("Tipo de gasolina no valido");
        if(litros <= 0)
            throw new GasolineraException("Cantidad de litros no valida");

        double litros_disponibles_surtidor = this.surtidores.get(tipo_combustible).get(surtidor - 1);
        double litros_resostados = Math.min(litros_disponibles_surtidor, litros);

        if(litros_resostados != 0){
            // Habia algo de gasolina en el surtidor
            if(this.repostajes.get(matricula) == null){
                // 1º vez
                this.repostajes.put(matricula, new TreeSet<>(ordenAlternativo));
            }
            // Añadimos el ticket
            this.repostajes.get(matricula).add(crearTicket(matricula, litros_resostados, precios.get(tipo_combustible)));
            // Descontamos la gasolina del surtidor
            this.surtidores.get(tipo_combustible).set(surtidor - 1, this.surtidores.get(tipo_combustible).get(surtidor - 1) - litros_resostados);
        }
    }

    protected Ticket crearTicket(String matricula, double litros, double precio_litro){
        Ticket t = new Ticket(contador, nombre, matricula, litros, precio_litro);
        contador++;
        return t;
    }

    public void facturar(String matricula){
        SortedSet<Ticket> tickets = this.repostajes.get(matricula);
        if(tickets == null)
            throw new GasolineraException("No existe ningun recibo asociada a esa matricula");

        // Generar el fichero
        try(PrintWriter pw = new PrintWriter(String.format("src\\main\\java\\Examenes\\_19SepGasolinera\\%s_%s.txt", nombre, matricula))){
            double total = 0.0;
            for(Ticket t : tickets) {
                if (!t.getFacturado()) {
                    pw.println(t);
                    t.setFacturado(true);
                    total += t.precioTotal();
                }
            }
            pw.printf("TOTAL = %.1f", total);
        }catch (FileNotFoundException ex){
            throw new GasolineraException("No se ha podido crear el fichero");
        }
    }

    public double obtenerConsumoFacturado(String matricula){
        double total = 0.0;
        for(Ticket t : this.repostajes.getOrDefault(matricula, new TreeSet<>())){
                if(t.getFacturado()){
                    total += t.precioTotal();
                }
        }
        return total;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        sj.add(String.format("%s = ", nombre));
        for(Map.Entry<String, List<Double>> ent : this.surtidores.entrySet()){
            sj.add(String.format("\t%s: %s", ent.getKey(), ent.getValue()));
        }
        SortedSet<Ticket> todos_tickets = new TreeSet<>(ordenAlternativo);
        for(SortedSet<Ticket> tickets : this.repostajes.values()){
            todos_tickets.addAll(tickets);
        }
        sj.add(String.format("\tRepostajes: %s", todos_tickets));
        return sj.toString();
    }
}
