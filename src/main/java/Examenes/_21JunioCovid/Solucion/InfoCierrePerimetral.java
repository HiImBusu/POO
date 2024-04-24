package Examenes._21JunioCovid.Solucion;

import java.util.HashSet;
import java.util.Set;

public class InfoCierrePerimetral implements InfoCOVID{

    @Override
    public Set<String> obtenerInfo(MapaCOVID mapa) {
        Set<String> provincias = new HashSet<>();
        for(String prov : mapa.getProvincias()){
            if(mapa.incidenciaProvincia(prov) > 500){
                provincias.add(prov);
            }
        }
        return provincias;
    }
}
