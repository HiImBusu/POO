package Examenes._20MayoEstelar.Solucion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Constelacion {
    private SortedSet<Estrella> estrellas;

    public Constelacion(){
        estrellas = new TreeSet<>();
    }

    public Constelacion(String fic) throws FileNotFoundException {
        // Creo el conjunto vacio
        this();

        // Intento leer el fichero para rellenarlo
        try(Scanner sc = new Scanner(Path.of(fic))){
            while(sc.hasNextLine()){
                procesar(sc.nextLine());
            }
        }catch (IOException ex){
            System.out.println("Error. No se ha podido abrir el fichero");
        }
    }
    private void procesar(String linea){
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter("[;]"); // Separador
            sc.useLocale(Locale.ENGLISH); // Decimales

            anyadeEstrellas(new Estrella(sc.next(), sc.next(), sc.nextDouble()));
        }catch (EstrellaException | NoSuchElementException  ex){
            System.out.println("Error al procesar la linea: " + linea);
        }
    }

    public void anyadeEstrellas(Estrella e){
        estrellas.add(e);
    }

    public double magnitudMedia(String nombre) throws EstrellaException {
        double suma = 0.0;
        int contador = 0;
        boolean hay_al_menos_una = false;
        for(Estrella e : estrellas){
            if(e.getNombre().equalsIgnoreCase(nombre)){
                hay_al_menos_una = true;
                suma += e.getMagnitud();
                contador++;
            }
        }
        if(!hay_al_menos_una)
            throw new EstrellaException("No existe ninguna estrella con ese nombre");

        return suma/contador;
    }

    public void eliminarEstrellas(String nombre){
        Iterator<Estrella> it = estrellas.iterator();
        while(it.hasNext()){
            if(it.next().getNombre().equalsIgnoreCase(nombre)){
                it.remove();
            }
        }
    }

    @Override
    public String toString() {
        return estrellas.toString();
    }

    public Collection<Estrella> getAgrupamiento(Seleccion s){
        SortedSet<Estrella> filtro = new TreeSet<>();
        for(Estrella e : estrellas){
            if(s.seleccionar(e)){
                filtro.add(e);
            }
        }
        return filtro;
    }

}
