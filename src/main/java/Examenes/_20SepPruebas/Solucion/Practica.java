package Examenes._20SepPruebas.Solucion;

public class Practica implements Comparable<Practica>{
    private String nombre;
    private String descripcion;
    private int cntRealizadas;
    private int cntExito;

    public Practica(String nom, String desc){
        this(nom, desc, 0, 0);
    }

    public Practica(String nom, String desc, int cRealizadas, int cExito){
        if(nom.isEmpty() || nom.isBlank() || desc.isEmpty() || desc.isBlank())
            throw new AppException();

        this.nombre = nom;
        this.descripcion = desc;
        this.cntRealizadas = cRealizadas;
        this.cntExito = cExito;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCntRealizadas() {
        return cntRealizadas;
    }

    public int getCntExito() {
        return cntExito;
    }

    public void setCntRealizadas(int cntRealizadas) {
        this.cntRealizadas = cntRealizadas;
    }

    public void setCntExito(int cntExito) {
        this.cntExito = cntExito;
    }
    public int getPorcExito(){
        if(cntRealizadas == 0)
            return 0;

        return (100 * cntExito) / cntRealizadas;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %d, %d, %d%%)", this.nombre, this.descripcion, this.cntRealizadas, this.cntExito, getPorcExito());
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Practica p) &&
                this.nombre.equalsIgnoreCase(p.nombre) &&
                this.descripcion.equalsIgnoreCase(p.descripcion);
    }


    @Override
    public int compareTo(Practica o) {
        int comp = this.nombre.compareToIgnoreCase(o.nombre);
        if(comp == 0)
            comp = this.descripcion.compareToIgnoreCase(o.descripcion);
        return comp;
    }
}
