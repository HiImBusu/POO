package Examenes.Procesiones.Solucion;

import java.util.ArrayList;
import java.util.List;

public class DistanciaMayor implements FiltradoUbicaciones{
    private int distanciaMinima;
    public DistanciaMayor(int dm){
        this.distanciaMinima = dm;
    }

    @Override
    public List<String> seleccionar(List<Ubicacion> ubicaciones) {
        List<String> nombres = new ArrayList<>();
        for(Ubicacion ub : ubicaciones){
            if(ub.getDistancia() >= distanciaMinima){
                nombres.add(ub.getNombre().toUpperCase());
            }
        }
        return nombres;
    }
}
