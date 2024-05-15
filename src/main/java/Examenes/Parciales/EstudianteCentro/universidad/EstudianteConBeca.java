package Examenes.Parciales.EstudianteCentro.universidad;

public class EstudianteConBeca extends Estudiante{
    private double umbralNota;

    public EstudianteConBeca(double un, String identificador, int cur, int cred, double notMe, boolean tiempoParcial){
        super(identificador, cur, cred, notMe, tiempoParcial);
        if(getNotaMedia() < un)
            throw new RuntimeException("El estudiante no supera la nota umbral");

        this.umbralNota = un;
    }
    private double subvencion(){
        double difTramos = (10.0 - this.umbralNota)/3;
        double corte1 = this.umbralNota + difTramos;
        double corte2 = corte1 + difTramos;
        double bonificacion = 0;
        if(getNotaMedia() < corte1)
            bonificacion = 75;
        else if(getNotaMedia() < corte2)
            bonificacion = 125;
        else
            bonificacion = 150;
        return bonificacion;
    }
    @Override
    public double getMatricula() {
        return super.getMatricula() - subvencion();
    }

    @Override
    public String toString() {
        return String.format("{%s (media: %.1f, umbral: %.1f); curso %d; %d creditos; %.1f euros}", getId(), getNotaMedia(), umbralNota, getCurso(), getCreditos(), getMatricula());
    }
}
