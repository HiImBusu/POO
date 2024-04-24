package Examenes._21JunioCovid;

import Examenes._21JunioCovid.Solucion.InfoCierrePerimetral;
import Examenes._21JunioCovid.Solucion.InfoPoblacion;
import Examenes._21JunioCovid.Solucion.MapaCOVID;

public class Main {
    public static void main(String[] args) {
        System.out.println("-- Creamos el mapa con los datos de entrada");
        MapaCOVID mapa = new MapaCOVID("Andalucia", "src\\main\\java\\Examenes\\_21JunioCovid\\datos.txt");
        System.out.println(mapa);

        System.out.println("\n-- Obtenemos las provincias que estan en un rango establecido");
        System.out.println(mapa.obtenerInfoCOVID(new InfoPoblacion(0, 150000)));

        System.out.println("\n-- Obtenemos las provincias que tenemos que cerrar perimetralmente");
        System.out.println(mapa.obtenerInfoCOVID(new InfoCierrePerimetral()));
    }
}
