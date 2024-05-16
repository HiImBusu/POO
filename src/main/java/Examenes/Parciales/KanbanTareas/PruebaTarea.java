package Examenes.Parciales.KanbanTareas;

import Examenes.Parciales.KanbanTareas.kanban.KanbanException;
import Examenes.Parciales.KanbanTareas.kanban.Tarea;

public class PruebaTarea {
    public static void main(String[] args) {
        try
        {
            Tarea t1 = new Tarea("NOINICIADA", "polo", 1, 10, 20);
            Tarea t2 = new Tarea("NOINICIADA", "polo", 5, 10, 20);
            System.out.println("Tarea 1: " + t1);
            System.out.println("Tarea 2: " + t2);

            if (t1.equals(t2))
            {
                System.out.println("SON IGUALES");
            }
            else
            {
                System.out.println("NO son iguales");
            }

            Tarea t3 = new Tarea("NOINI3CIADA", "polo", 5, 10, 20);
            Tarea t4 = new Tarea("NOINICIADA", "polo", 0, 10, 20);
            Tarea t5 = new Tarea("NOINICIADA", "polo", 5, -10, 20);
            System.out.println("Tarea 3: " + t3);
            System.out.println("Tarea 4: " + t4);
            System.out.println("Tarea 5: " + t5);

        } catch (KanbanException e)
        {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
