package Examenes.Parciales.EstudianteCentro.universidad;

import java.util.ArrayList;
import java.util.List;

public class Centro {
    List<Estudiante> matriculados;

    public Centro(){
        matriculados = new ArrayList<>();
    }
    public void addEstudiante(String id, int cur, int cred, double nota, boolean tiempoParcial){
        addEstudiante(new Estudiante(id, cur, cred, nota, tiempoParcial));
    }

    protected int buscarEstudiante(String id){
        int index = -1;
        for (int i = 0; i < matriculados.size(); i++) {
            if(matriculados.get(i).getId().equalsIgnoreCase(id)){
                index = i;
            }
        }
        return index;
    }

    protected void addEstudiante(Estudiante e){
        int index = buscarEstudiante(e.getId());
        if(index == -1)
            matriculados.add(e);
        else
            matriculados.set(index, e);
    }

    public List<Estudiante> getListaCurso(int curso){
        List<Estudiante> est = new ArrayList<>();
        for(Estudiante e : matriculados){
            if(e.getCurso() == curso){
                est.add(e);
            }
        }
        return est;
    }

    @Override
    public String toString() {
        return matriculados.toString();
    }
}
