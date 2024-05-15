package Examenes.Procesiones.Solucion;

import java.util.*;

public class Procesion {
    private String cofradia;
    private List<Ubicacion> itinerario;

    public Procesion(String cof, String salida){
        this.cofradia = cof;
        this.itinerario = new ArrayList<>();
        this.itinerario.add(new Ubicacion(salida));
    }

    public String getCofradia() {
        return cofradia;
    }
    public void agregarUbicacion(Ubicacion ubic){
        int index = buscarUbicacion(ubic);
        if(index == -1)
            itinerario.add(ubic);
        else
            itinerario.set(index, ubic);
    }

    private int buscarUbicacion(Ubicacion ubic){
        int index = -1;
        for (int i = 0; i < itinerario.size(); i++) {
            if(itinerario.get(i).equals(ubic)){
                index = i;
            }
        }
        return index;
    }

    public void agregarUbicacion(String infoUbicacion){
        try(Scanner sc = new Scanner(infoUbicacion)){
            sc.useDelimiter("[#]");
            agregarUbicacion(new Ubicacion(sc.next(), sc.nextInt(), sc.nextInt()));
        }catch (InputMismatchException ex){
            throw new ProcesionesException("Formato incorrecto (dato no numérico): " + infoUbicacion);
        }catch (NoSuchElementException ex){
            throw new ProcesionesException("Formato incorrecto (faltan datos): " + infoUbicacion);
        }catch (ProcesionesException ex){
            throw new ProcesionesException("Formato incorrecto (numero negativo): " + infoUbicacion);
        }
    }

    public List<String> ubicacionesLejanas(int distancia){
        /*
        List<String> nombres = new ArrayList<>();
        for(Ubicacion ub : itinerario){
            if(ub.getDistancia() >= distancia){
                nombres.add(ub.getNombre());
            }
        }
        return nombres;
        */

        // return new DistanciaMayor(distancia).seleccionar(itinerario);

        return seleccionarUbicaciones(new DistanciaMayor(distancia));
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" -> ", "{", "}");
        for(Ubicacion ub : itinerario){
            sj.add(ub.toString());
        }
        return String.format("%s @ %s", cofradia, sj.toString());
    }
    public List<String> seleccionarUbicaciones(FiltradoUbicaciones filtro){
        return filtro.seleccionar(itinerario);
    }
}
