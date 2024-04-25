package Examenes._20JunioDados.Solucion;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public abstract class Juego implements Simulacion{
    @Override
    public List<Integer> experimento(int numSim) {
        if(numSim <= 0)
            throw new IllegalArgumentException();

        List<Integer> simulaciones = new ArrayList<>();
        for(int sim = 1; sim <= numSim; sim++){
            simulaciones.add(simula());
        }
        return simulaciones;
    }

    @Override
    public SortedMap<Integer, Integer> agrupa(List<Integer> list) {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        for(Integer sim : list){
            if(map.get(sim) == null){
                // 1º vez
                map.put(sim, 1);
            }else{
                map.put(sim, map.get(sim) + 1);
            }
        }
        return map;
    }
}
