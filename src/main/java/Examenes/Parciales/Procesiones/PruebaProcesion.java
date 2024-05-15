package Examenes.Parciales.Procesiones;

import Examenes.Parciales.Procesiones.Solucion.DistanciaMayor;
import Examenes.Parciales.Procesiones.Solucion.Procesion;
import Examenes.Parciales.Procesiones.Solucion.ProcesionesException;
import Examenes.Parciales.Procesiones.Solucion.TiempoMenor;

public class PruebaProcesion {
    public static void main(String[] args) {
        Procesion p = new Procesion("Estudiantes", "Casa Hermandad C/ Alcazabilla");
        try{
            p.agregarUbicacion("Mármoles#60#-100");
        }catch (ProcesionesException ex){
            System.err.println(ex.getMessage());
        }
        try{
            p.agregarUbicacion("Catedral#390");
        }catch (ProcesionesException ex){
            System.err.println(ex.getMessage());
        }

        p.agregarUbicacion("Tribuna#250#900");
        p.agregarUbicacion("Larios#270#1000");
        p.agregarUbicacion("Alameda#300#1500");
        p.agregarUbicacion("Molina Larios#330#1900");
        p.agregarUbicacion("Torre Sur#360#2100");
        System.out.println(p);

        System.out.println("Las ubicaciones con tiempo menor de 300 minutos son: ");
        System.out.println(p.seleccionarUbicaciones(new TiempoMenor(300)));

        System.out.println("Las ubicaciones con distancia mayor de 1000 metros son: ");
        System.out.println(p.seleccionarUbicaciones(new DistanciaMayor(1000)));
    }
}
