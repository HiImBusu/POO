package Examenes.Parciales.KanbanTareas.kanban;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriterioPrioridad implements Criterio{
    private int prioridad;
    public CriterioPrioridad(int prio){
        this.prioridad = prio;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public Tarea[] filtrar(Tarea[] tareas) {
        Tarea[] ltareas = new Tarea[tareas.length];
        int n_tareas = 0;
        for(Tarea t : tareas){
            if(t.getPrioridad() == this.prioridad){
                ltareas[n_tareas] = t;
                n_tareas++;
            }
        }
        return Arrays.copyOf(ltareas, n_tareas);
    }
}
