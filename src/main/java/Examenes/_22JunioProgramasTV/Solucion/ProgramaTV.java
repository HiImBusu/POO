package Examenes._22JunioProgramasTV.Solucion;

import Examenes._22JunioProgramasTV.Hora;

public class ProgramaTV implements Comparable<ProgramaTV>{
    private String nombre;
    private Hora horaInicio;
    private int duracion;

    public ProgramaTV(String nom, Hora h, int dur){
        if(dur < 0)
            throw new ProgramacionTVException("La duracion no puede ser negativa");
        this.nombre = nom;
        this.horaInicio = h;
        this.duracion = dur;
    }

    public String getNombre() {
        return nombre;
    }

    public Hora getHoraInicio() {
        return horaInicio;
    }

    public int getDuracion() {
        return duracion;
    }
    public Hora getHoraFin(){
        Hora fin = new Hora(horaInicio.getHora(), horaInicio.getMinuto());
        fin.incrementar(duracion);
        return fin;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof ProgramaTV p) &&
                nombre.equalsIgnoreCase(p.nombre) &&
                horaInicio.equals(p.horaInicio) &&
                duracion == p.duracion;
    }


    @Override
    public int compareTo(ProgramaTV o) {
        int comp = horaInicio.compareTo(o.horaInicio);
        if(comp == 0)
            comp = Integer.compare(duracion, o.duracion);
        if(comp == 0)
            comp = nombre.compareToIgnoreCase(o.nombre);
        return comp;
    }

    @Override
    public String toString() {
        return String.format("%s@%s-%d", nombre.toUpperCase(), horaInicio, duracion);
    }
}
