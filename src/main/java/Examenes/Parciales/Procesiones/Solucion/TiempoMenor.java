package Examenes.Parciales.Procesiones.Solucion;

import java.util.ArrayList;
import java.util.List;

public class TiempoMenor implements FiltradoUbicaciones{
    private int tiempoMaximo;
    public TiempoMenor(int tm){
        this.tiempoMaximo = tm;
    }
    @Override
    public List<String> seleccionar(List<Ubicacion> ubicaciones) {
        List<String> nombres = new ArrayList<>();
        for(Ubicacion ub : ubicaciones){
            if(ub.getMinutos() <= this.tiempoMaximo){
                nombres.add(ub.getNombre().toUpperCase());
            }
        }
        return nombres;
    }
}
