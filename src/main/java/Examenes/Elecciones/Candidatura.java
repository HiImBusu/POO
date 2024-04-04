package Examenes.Elecciones;

import java.util.ArrayList;
import java.util.List;

public class Candidatura {
    // Atributos
    private String partido;
    private String circunscripcion;
    private List<Candidata> candidatura;

    public Candidatura(String part, String circuns){
        this.partido = part;
        this.circunscripcion = circuns;
        this.candidatura = new ArrayList<>();
    }

    public String getPartido() {
        return partido;
    }

    public String getCircunscripcion() {
        return circunscripcion;
    }

    public void agregarMiembro(Candidata cand){
        int index = buscarDNI(cand.getDNI());
        if(index == -1){
            candidatura.add(cand);
        }else{
            candidatura.set(index, cand);
        }
    }
    public void eliminarMiembro(Candidata cand){
        int index = buscarDNI(cand.getDNI());
        if(index == -1){
            throw new RuntimeException();
        }else{
            candidatura.remove(index);
        }
    }
    private int buscarDNI(String dni){
        int index = -1;
        for(int i = 0; i < candidatura.size(); i++){
            if(candidatura.get(i).getDNI().equalsIgnoreCase(dni)){
                index = i;
            }
        }
        return index;
    }
    public void agregarCabezaLista(Candidata cand){
        candidatura.add(0, cand);
    }
    public Candidata cabezaLista(){
        if(candidatura.size() == 0)
            throw new RuntimeException();

        return candidatura.get(0);
    }

    public int numeroIndependientes(){
        int contador = 0;
        for(Candidata c : candidatura){
            if(c.esIndependiente()){
                contador++;
            }
        }
        return contador;
    }
    public boolean esCremallera(){
        boolean ok = true;
        for(int i = 0; i < candidatura.size() - 1; i++){
            if(candidatura.get(i).getSexo() == candidatura.get(i + 1).getSexo()){
                ok = false;
            }
        }
        return ok;
    }

    @Override
    public String toString() {
        return String.format("%s-%s:%s", this.partido, this.circunscripcion, this.candidatura);
    }
}
