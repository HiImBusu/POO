package Examenes._16JunioAsignaciones.Solucion;

import Examenes._16JunioAsignaciones.FranjaHoraria;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class Asignaciones {
    private SortedMap<Integer, SortedSet<PeticionAsignacion>> asignacion;
    protected List<PeticionAsignacion> conflictos;
    private final int NUM_LAB;

    public Asignaciones(int laboratorios){
        if(laboratorios < 1)
            throw new AsignacionException("Error, numero de laboratorios no valido: " + laboratorios);

        this.NUM_LAB = laboratorios;
        this.asignacion = new TreeMap<>();
        this.conflictos = new ArrayList<>();

        // Rellenamos el mapa asignacion con los laboratorios
        for(int lab = 1; lab <= this.NUM_LAB; lab++){
            this.asignacion.put(lab, new TreeSet<>());
        }
    }
    public Asignaciones(int laboratorios, String fichero) throws FileNotFoundException {
        this(laboratorios);
        leerPeticionesDeFichero(fichero);
    }

    public Set<Integer> buscarHuecos(FranjaHoraria franja){
        SortedSet<Integer> laboratorios_disponibles = new TreeSet<>();
        PeticionAsignacion p = new PeticionAsignacion("", "", franja);

        for(Map.Entry<Integer, SortedSet<PeticionAsignacion>> entry : this.asignacion.entrySet()){
            if(!entry.getValue().contains(p)){
                // Si no tiene ninguna peticion con la misma franja, lo meto en mi conjunto
                laboratorios_disponibles.add(entry.getKey());
            }
        }
        return laboratorios_disponibles;
    }

    public boolean nuevaAsignacion(PeticionAsignacion pa){
        Set<Integer> laboratorios_disponibles = buscarHuecos(pa.getFranja());
        boolean algun_laboratorio_disponible = false;
        if(!laboratorios_disponibles.isEmpty()){
            // Si hay algun laboratorio
            algun_laboratorio_disponible = true;
            this.asignacion.get(laboratorios_disponibles.iterator().next()).add(pa);
        }
        return algun_laboratorio_disponible;
    }

    public void realizarAsignacion(String linea){
        String prof, asig, dia, hora;
        PeticionAsignacion pet;
        boolean intenta_asignar_laboratorio;
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter("[#]");
            asig = sc.next();
            prof = sc.next();
            dia = sc.next();
            hora = sc.next();
            pet = new PeticionAsignacion(prof, asig, new FranjaHoraria(dia, hora));
            intenta_asignar_laboratorio = nuevaAsignacion(pet);
            if(!intenta_asignar_laboratorio){
                // Si no consegui asignarle un laboratorio, lo meto en "conflictos"
                this.conflictos.add(pet);
            }
        }catch (Exception ex){
            throw new AsignacionException(ex.getMessage());
        }
    }

    public void leerPeticionesDeFichero(String nf) throws FileNotFoundException {
        try(Scanner sc = new Scanner(Path.of(nf))){
            while(sc.hasNextLine()){
                realizarAsignacion(sc.nextLine());
            }
        }catch (IOException ex){
            throw new FileNotFoundException(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asignacion de laboratorios\n");
        sb.append("--------------------------\n");
        for(Map.Entry<Integer, SortedSet<PeticionAsignacion>> entry : this.asignacion.entrySet()){
            sb.append(String.format("Laboratorio %d\n", entry.getKey()));
            for(PeticionAsignacion pet : entry.getValue()){
                sb.append("\t" + pet + "\n");
            }
        }
        sb.append("Conflictos\n");
        sb.append("----------\n");
        for(PeticionAsignacion pet : this.conflictos){
            sb.append("\t" + pet + "\n");
        }
        return sb.toString();
    }

    public void escribirAFichero(String fichero) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(fichero)){
            escribirAsignaciones(pw);
        }
    }
    public void escribirAsignaciones(PrintWriter pw){
        pw.print(this.toString());
    }

}
