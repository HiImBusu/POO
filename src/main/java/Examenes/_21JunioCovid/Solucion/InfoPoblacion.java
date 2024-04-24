package Examenes._21JunioCovid.Solucion;

import java.util.HashSet;
import java.util.Set;

public class InfoPoblacion implements InfoCOVID{
    private int rangoMinimo, rangoMaximo;
    public InfoPoblacion(int min, int max){
        if(min < 0)
            throw new COVIDException("Minimo no valido");

        this.rangoMinimo = min;
        this.rangoMaximo = max;
    }

    @Override
    public Set<String> obtenerInfo(MapaCOVID mapa) {
        Set<String> dist = new HashSet<>();
        for(DistritoSanitario ds : mapa.getDistritos()){
            if(ds.getPoblacion() >= rangoMinimo && ds.getPoblacion() <= rangoMaximo){
                dist.add(ds.getDistrito());
            }
        }
        return dist;
    }
}
