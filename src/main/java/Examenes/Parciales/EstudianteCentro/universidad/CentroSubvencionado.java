package Examenes.Parciales.EstudianteCentro.universidad;

public class CentroSubvencionado extends Centro{
    private double umbral;
    public CentroSubvencionado(double umb){
        this.umbral = umb;
    }

    @Override
    public void addEstudiante(String id, int cur, int cred, double nota, boolean tiempoParcial) {
        if(nota >= umbral)
            super.addEstudiante(new EstudianteConBeca(umbral, id, cur, cred, nota, tiempoParcial));
        else
            super.addEstudiante(new Estudiante(id, cur, cred, nota, tiempoParcial));
    }

    @Override
    public String toString() {
        return String.format("Nota minima para beca: %.1f\n%s", umbral, super.toString());
    }
}
