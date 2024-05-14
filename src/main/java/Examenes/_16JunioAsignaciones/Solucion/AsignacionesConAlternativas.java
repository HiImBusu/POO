package Examenes._16JunioAsignaciones.Solucion;

import Examenes._16JunioAsignaciones.FranjaHoraria;

import java.io.FileNotFoundException;
import java.util.*;

public class AsignacionesConAlternativas extends Asignaciones{
    public AsignacionesConAlternativas(int laboratorios, String fichero) throws FileNotFoundException {
        super(laboratorios, fichero);
    }

    private Set<PeticionAsignacion> leerAlternativas(String linea){
        String prof, asig, dia, hora;
        SortedSet<PeticionAsignacion> peticiones = new TreeSet<>();
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter("[#]");

            asig = sc.next();
            prof = sc.next();
            dia = sc.next();
            hora = sc.next();
            peticiones.add(new PeticionAsignacion(prof, asig, new FranjaHoraria(dia, hora)));
            while(sc.hasNext()){
                dia = sc.next();
                hora = sc.next();
                peticiones.add(new PeticionAsignacion(prof, asig, new FranjaHoraria(dia, hora)));
            }
            return peticiones;
        }catch (Exception ex){
            throw new AsignacionException(ex.getMessage());
        }
    }

    @Override
    public void realizarAsignacion(String linea) {
        Set<PeticionAsignacion> peticiones = leerAlternativas(linea);
        Iterator<PeticionAsignacion> it = peticiones.iterator();
        PeticionAsignacion pet;
        boolean intenta_asignar_laboratorio = false;
        if(peticiones.isEmpty())
            throw new AsignacionException("Error, no se han generado ningun conjunto de peticiones posibles");

        while(it.hasNext() && !intenta_asignar_laboratorio){
            pet = it.next();
            intenta_asignar_laboratorio = nuevaAsignacion(pet);
        }
        if(!intenta_asignar_laboratorio){
            // Si no consiguio meter ninguna peticion, meto alguna de ellas en "conflictos"
            this.conflictos.add(peticiones.iterator().next());
        }
    }
}
