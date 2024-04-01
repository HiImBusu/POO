package Practicas.pr3LibreriaExtendida;

public class Libro {
    // Atributos
    private static double porcIVA = 10;
    private String autor;
    private String titulo;
    private double precioBase;

    // Metodos
    // Constructor
    public Libro(String aut, String tit, double pre){
        this.autor = aut;
        this.titulo = tit;
        this.precioBase = pre;
    }
    // Getters/Setters
    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }
    protected double getBaseImponible(){
        return this.getPrecioBase();
    }
    public double getPrecioFinal(){
        return this.getBaseImponible() + (this.getBaseImponible() * (Libro.porcIVA / 100));
        // return this.getBaseImponible() + (this.getBaseImponible() * (this.porcIVA / 100));
    }

    @Override
    public String toString() {
        // (autor, título; precioBase; porcentajeIva; precioFinal)
        // %s: String
        // %d: int
        // %f: double/float
        // %.2f: double/float CON DOS DECIMALES SOLO!
        return String.format("(%s; %s; %.2f; %.2f; %.2f)",
                this.autor, this.titulo, this.getPrecioBase(), Libro.porcIVA, this.getPrecioFinal());
    }

    public static double getIVA(){
        return Libro.porcIVA;
    }
    public static void setIVA(double iva){
        Libro.porcIVA = iva;
    }
}
