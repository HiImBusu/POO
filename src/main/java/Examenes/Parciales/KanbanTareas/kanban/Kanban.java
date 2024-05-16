package Examenes.Parciales.KanbanTareas.kanban;

import java.util.Arrays;

public class Kanban {
    private Tarea[] tareas;

    public Kanban(String[] tar){
        // Inicialmente le damos el mismo tamaño
        int n_tareas_actuales = 0;
        tareas = new Tarea[tar.length];

        // Recorremos la lista de tareas
        String[] t_desglosada;
        for(String t : tar){
            // Separamos por el caracter ';'
            t_desglosada = t.split(";");

            try{
                // Intentamos leer la tarea e insertarla en la primera posicion libre
                tareas[n_tareas_actuales] = new Tarea(
                        t_desglosada[0],
                        t_desglosada[1],
                        Integer.parseInt(t_desglosada[2]),
                        Double.parseDouble(t_desglosada[3]),
                        Double.parseDouble(t_desglosada[4]));
                n_tareas_actuales++;
            }catch(KanbanException | NumberFormatException | IndexOutOfBoundsException ex){
                // Si al leer algo va mal no lo metemos en el array y mostramos el error
                System.out.println("Error de formato: " + t);
            }
        }

        // Una vez volcadas todas, redimensionamos el array
        tareas = Arrays.copyOf(tareas, n_tareas_actuales);
    }

    public String resumenTareas(){
        return String.format("RESUMEN DE TAREAS\n%d No iniciada. %d En proceso. %d Terminada.\nHoras consumidas: %.1f. Horas estimadas: %.1f",
                filtrar_estado("NOINICIADA"), filtrar_estado("ENPROCESO"), filtrar_estado("TERMINADA"), horas_consumidas_totales(), horas_estimadas_totales());
    }

    private int filtrar_estado(String estado){
        int contador = 0;
        for(Tarea t : tareas){
            if(t.getEstado().equalsIgnoreCase(estado)){
                contador++;
            }
        }
        return contador;
    }
    private double horas_consumidas_totales(){
        double total = 0.0;
        for(Tarea t : tareas){
            total += t.getHorasConsumidas();
        }
        return total;
    }
    private double horas_estimadas_totales(){
        double total = 0.0;
        for(Tarea t : tareas){
            total += t.getHorasEstimadas();
        }
        return total;
    }

    @Override
    public String toString() {
        return Arrays.toString(tareas);
    }

    public Tarea[] seleccionar(Criterio criterio){
        return criterio.filtrar(tareas);
    }
}
