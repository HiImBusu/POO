package Examenes.Parciales.KanbanTareas.kanban;

public class Tarea {
    private String estado;
    private final String titulo;
    private int prioridad;
    private final double horasEstimadas;
    private double horasConsumidas;

    public Tarea(String est, String tit, int prio, double he, double hc) throws KanbanException {
        if(tit == null || tit.isEmpty() || tit.isBlank())
            throw new KanbanException("Titulo no valido");

        if(!esEstadoValido(est))
            throw new KanbanException("Estado no valido");

        if(prio < 1 || prio > 5)
            throw new KanbanException("Prioridad no valida");

        if(hc < 0)
            throw new KanbanException("Horas consumidas no valido");

        if(he <= 0)
            throw new KanbanException("Horas estimadas no valido");

        this.estado = est;
        this.titulo = tit;
        this.prioridad = prio;
        this.horasEstimadas = he;
        this.horasConsumidas = hc;
    }


    protected Tarea(String tit) throws KanbanException {
        this("NOINICIADA", tit, 1, 1, 0);
    }

    public static boolean esEstadoValido(String estado){
        return estado.equals("NOINICIADA") || estado.equals("ENPROCESO") || estado.equals("TERMINADA");
    }

    public String getEstado() {
        return estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public double getHorasEstimadas() {
        return horasEstimadas;
    }

    public double getHorasConsumidas() {
        return horasConsumidas;
    }

    public void setEstado(String est) throws KanbanException {
        if(!esEstadoValido(est))
            throw new KanbanException("Estado no valido");
        this.estado = est;
    }

    public void setHorasConsumidas(double hc) throws KanbanException {
        if(hc < 0)
            throw new KanbanException("Horas consumidas no valido");
        this.horasConsumidas = hc;
    }

    public void setPrioridad(int prio) throws KanbanException {
        if(prio < 1 || prio > 5)
            throw new KanbanException("Prioridad no valida");
        this.prioridad = prio;
    }

    @Override
    public String toString() {
        return String.format("Tarea: %s. %s prioridad: %d horas:(%.1f/%.1f)", titulo, estado, prioridad, horasConsumidas, horasEstimadas);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Tarea t) &&
                this.titulo.equalsIgnoreCase(t.titulo);
    }
}
