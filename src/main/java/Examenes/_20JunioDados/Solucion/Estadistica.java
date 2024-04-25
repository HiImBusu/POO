package Examenes._20JunioDados.Solucion;

import java.util.*;

public class Estadistica {
    private SortedMap<Integer, Integer> experimentos;
    public Estadistica(SortedMap<Integer, Integer> exp){
        this.experimentos = exp;
    }
    public double media(){
        double suma = 0.0;
        double contadorJugadas = 0.0;
        for(Map.Entry<Integer, Integer> entry : this.experimentos.entrySet()){
            suma += entry.getKey() * entry.getValue();
            contadorJugadas += entry.getValue();
        }
        return suma/contadorJugadas;
    }

    public Set<Integer> moda(){
        Set<Integer> conj = new HashSet<>();
        int maximo = 1;
        for(Map.Entry<Integer, Integer> entry : this.experimentos.entrySet()){
            if(entry.getValue() == maximo){
                // si es el mismo que tenia como de momento mnaximo, lo añadimos
                conj.add(entry.getKey());
            }else if(entry.getValue() > maximo){
                // Si encontramos algo mayor
                // actualizamos
                maximo = entry.getValue();
                // reiniciamos conjunto
                conj.clear();
                // metemos el nuevo elemento
                conj.add(entry.getKey());
            }
        }
        return conj;
    }

    public int mediana(){
        List<Integer> list = new ArrayList<>();
        // Metemos los valores tantas veces como diga la clave
        for(Map.Entry<Integer, Integer> entry : this.experimentos.entrySet()){
            for(int veces = 1; veces <= entry.getValue(); veces++){
                list.add(entry.getKey());
            }
        }
        // Seleccionamos el elemento central
        return list.get((list.size()/2) - 1);
    }


}
