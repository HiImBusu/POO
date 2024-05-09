package Examenes._17JunioRegata.Solucion;

import Examenes._17JunioRegata.Posicion;

import java.util.Comparator;

public class SatBarco implements Comparator<Barco> {
    @Override
    public int compare(Barco o1, Barco o2) {
        Posicion referencia = new Posicion(0, 0);
        int comp = Double.compare(o1.posicion.distancia(referencia), o2.posicion.distancia(referencia));
        if(comp == 0)
            comp = o1.compareTo(o2);
        return comp;
    }
}
