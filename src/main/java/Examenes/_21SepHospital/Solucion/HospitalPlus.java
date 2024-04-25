package Examenes._21SepHospital.Solucion;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class HospitalPlus extends Hospital{
    public HospitalPlus(String name, int floors, int rooms) throws HospitalException {
        super(name, floors, rooms);
    }
    public SortedMap<Integer, SortedSet<Patient>> patientsPerYear(){
        SortedMap<Integer, SortedSet<Patient>> map = new TreeMap<>();
        for(Patient pat : this.rooms.keySet()){
            if(map.get(pat.getBirthYear()) == null){
                // 1º vez
                map.put(pat.getBirthYear(), new TreeSet<>());
            }
            map.get(pat.getBirthYear()).add(pat);
        }
        return map;
    }
    public SortedMap<Integer, Integer> numberOfPatientsPerYear(){
        SortedMap<Integer, Integer> map = new TreeMap<>();
        for(Patient pat : this.rooms.keySet()){
            if(map.get(pat.getBirthYear()) == null){
                // 1º vez
                map.put(pat.getBirthYear(), 1);
            }else{
                map.put(pat.getBirthYear(), map.get(pat.getBirthYear()) + 1);
            }
        }
        return map;
    }
}
