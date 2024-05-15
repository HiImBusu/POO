package Examenes.Parciales.Elecciones;

public class Candidata {
    // Definiciones internas
    public static enum Sexo {F, M};

    // Atributos
    private String nombre;
    private String DNI;
    private String partido;
    private Sexo sexo;

    public Candidata(String nom, String dni, Sexo sex, String partido){
        this.nombre = nom;
        this.DNI = dni;
        this.sexo = sex;
        this.partido = partido;
    }

    public Candidata(String nom, String dni, Sexo sex){
        this(nom, dni, sex, null);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getPartido() {
        return partido;
    }
    boolean esIndependiente(){
        return partido == null || partido.isEmpty();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public void cambiarSexo(){
        if(this.sexo == Sexo.F)
            this.sexo = Sexo.M;
        else{
            this.sexo = Sexo.F;
        }
    }

    @Override
    public String toString() {
        return String.format("%s%s", this.nombre.toUpperCase(), esIndependiente() ? " (independiente)" : "");
    }
}
