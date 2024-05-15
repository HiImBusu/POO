package Examenes.Parciales.EstudianteCentro.universidad;

public class Estudiante {
    private String id;
    private int curso;
    private int creditos;
    private boolean tp;
    private double notaMedia;
    private static final double expediente = 59.0;
    private static final double mantenimiento = 5.7;
    private static final double precioCredito = 22.5;

    public Estudiante(String identificador, int cur, int cred, double notMe, boolean tiempoParcial){
        if(cur < 1 || cur > 4)
            throw new RuntimeException("Curso no valido");
        if(tiempoParcial) {
            if (cred < 24)
                throw new RuntimeException("Cantidad de creditos no valida");
        }else{
           if(cur == 1 && cred < 60)
               throw new RuntimeException("Cantidad de creditos no valida");
           else if(cur != 1 && cred < 48)
               throw new RuntimeException("Cantidad de creditos no valida");
        }

        this.id = identificador;
        this.curso = cur;
        this.creditos = cred;
        this.tp = tiempoParcial;
        this.notaMedia = notMe;
    }

    public int getCreditos() {
        return creditos;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public String getId() {
        return id;
    }

    public int getCurso() {
        return curso;
    }

    public double getMatricula(){
        if(curso == 1)
            return expediente + mantenimiento + (precioCredito * creditos);
        else
            return mantenimiento + (precioCredito * creditos);
    }

    @Override
    public String toString() {
        return String.format("{%s (media: %.1f); curso %d; %d creditos; %.1f euros}", id, notaMedia, curso, creditos, getMatricula());
    }
}
