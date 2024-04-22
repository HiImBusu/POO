package Practicas.pr2Libreria;

import java.util.Locale;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Libro l) &&
                titulo.equalsIgnoreCase(l.titulo) &&
                autor.equalsIgnoreCase(l.autor) &&
                precioBase == l.precioBase;
    }

    @Override
    public int hashCode() {
        // return titulo.toLowerCase().hashCode() + autor.toLowerCase().hashCode() + Double.hashCode(precioBase);
        return Objects.hash(titulo.toLowerCase(), autor.toLowerCase(), precioBase);
    }
}
