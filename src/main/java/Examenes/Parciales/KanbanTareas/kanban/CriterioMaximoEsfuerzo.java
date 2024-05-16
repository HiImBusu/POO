package Examenes.Parciales.KanbanTareas.kanban;

import java.util.Arrays;

public class CriterioMaximoEsfuerzo implements Criterio{
    @Override
    public Tarea[] filtrar(Tarea[] tareas) {
        double mayor = buscar_mayor_horas_estimadas(tareas);
        Tarea[] ltareas = new Tarea[tareas.length];
        int n_tareas = 0;
        for(Tarea t : tareas){
            if(t.getHorasEstimadas() == mayor){
                ltareas[n_tareas] = t;
                n_tareas++;
            }
        }
        return Arrays.copyOf(ltareas, n_tareas);
    }
    private double buscar_mayor_horas_estimadas(Tarea[] tareas){
        double mayor = tareas[0].getHorasEstimadas();
        for (int i = 1; i < tareas.length; i++) {
            if(tareas[i].getHorasEstimadas() > mayor){
                mayor = tareas[i].getHorasEstimadas();
            }
        }
        return mayor;
    }
}
