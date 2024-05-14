package Examenes._16JunioAsignaciones.Solucion;

import Examenes._16JunioAsignaciones.FranjaHoraria;

public class PeticionAsignacion implements Comparable<PeticionAsignacion>{
    private String profesor;
    private String asignatura;
    private FranjaHoraria franja;

    public PeticionAsignacion(String prof, String asig, FranjaHoraria fra){
        this.profesor = prof;
        this.asignatura = asig;
        this.franja = fra;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public FranjaHoraria getFranja() {
        return franja;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public void setFranja(FranjaHoraria franja) {
        this.franja = franja;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s, %s", franja, asignatura, profesor);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof PeticionAsignacion p) &&
                this.franja.equals(p.franja);
    }


    @Override
    public int compareTo(PeticionAsignacion o) {
        int comp = this.franja.getDia().compareTo(o.franja.getDia());
        if(comp == 0)
            comp = this.franja.getHora().compareTo(o.franja.getHora());
        return comp;
    }
}
