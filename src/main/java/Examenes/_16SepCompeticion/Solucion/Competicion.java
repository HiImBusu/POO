package Examenes._16SepCompeticion.Solucion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.CompletionException;

public class Competicion {
    private SortedMap<Equipo, List<Jugador>> competicion;
    public Competicion(){
        this.competicion = new TreeMap<>();
    }
    public Competicion(String fic) throws FileNotFoundException {
        this();
        leerDatos(fic);
    }
    public void leerDatos(String fic) throws FileNotFoundException {
        try(Scanner sc = new Scanner(Path.of(fic))){
            while(sc.hasNextLine()){
                procesar(sc.nextLine());
            }
        }catch (IOException ex){
            throw new FileNotFoundException();
        }
    }
    private void procesar(String linea){
        Equipo equipo;
        List<Jugador> jugadores = new ArrayList<>();
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter("[:]");
            equipo = new Equipo(sc.next(), sc.nextInt(), sc.nextInt());
            while(sc.hasNext()){
                jugadores.add(new Jugador(sc.next(), sc.nextInt(), sc.nextInt()));
            }
            insertaJugadoresEquipo(equipo, jugadores);
        }catch (InputMismatchException ex){
            throw new CompeticionException("Alguno de los argumentos no es del tipo que se espera: " + linea);
        }catch (NoSuchElementException ex){
            throw new CompeticionException("Faltan argumentos en la linea: " + linea);
        }
    }
    public void insertaJugadoresEquipo(Equipo eq, List<Jugador> jugadores){
        if(competicion.containsKey(eq)){
            for(Jugador jug : jugadores){
                if(!competicion.get(eq).contains(jug)){
                    competicion.get(eq).add(jug);
                }
            }
        }else{
            competicion.put(eq, jugadores);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Equipo, List<Jugador>> entry : competicion.entrySet()){
            sb.append(entry.getKey() + "\n");
            for(Jugador jug : entry.getValue()){
                sb.append("\t" + jug + "\n");
            }
        }
        return sb.toString();
    }

    public void escribirFichero(String fic) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(fic)){
            escribir(pw);
        }
    }
    public void escribir(PrintWriter pw){
        pw.print(this);
    }

    public void increPartidos(String nombre, int nPartidos, int nGanados){
        Jugador jug = buscarJugador(nombre);
        if(jug == null)
            throw new CompeticionException("El jugador " + nombre + " no se encuentra en ningun equipo");

        jug.increPartidos(nPartidos, nGanados);
    }

    private Jugador buscarJugador(String nombre){
        Iterator<List<Jugador>> it = competicion.values().iterator();
        List<Jugador> list;
        Iterator<Jugador> itJug;
        Jugador jugador;
        Jugador jugador_buscado = null;
        while(it.hasNext() && jugador_buscado == null){
            list = it.next();
            itJug = list.iterator();
            while(itJug.hasNext() && jugador_buscado == null){
                jugador = itJug.next();
                if(jugador.getNombre().equalsIgnoreCase(nombre)){
                    jugador_buscado = jugador;
                }
            }
        }
        return jugador_buscado;
    }




}
