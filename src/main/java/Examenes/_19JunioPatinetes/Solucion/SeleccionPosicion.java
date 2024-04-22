package Examenes._19JunioPatinetes.Solucion;

import Examenes._19JunioPatinetes.Posicion;

public class SeleccionPosicion implements Seleccion{
    private Posicion posicionRef;
    private double distanciaMax;
    public SeleccionPosicion(Posicion pos, double dist){
        this.posicionRef = pos;
        this.distanciaMax = dist;
    }

    @Override
    public boolean seleccionar(Patinete p) {
        return p.getPosicion().distancia(posicionRef) < distanciaMax;
    }
}
