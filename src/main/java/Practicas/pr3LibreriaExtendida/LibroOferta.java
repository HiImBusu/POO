package Practicas.pr3LibreriaExtendida;

public class LibroOferta extends Libro{
    // Atributos
    private double porcDescuento;

    // Metodos
    public LibroOferta(String aut,
                       String tit,
                       double pre,
                       double desc)
    {
        // Construyo el libro como mi padre
        super(aut, tit, pre);
        // Y a parte... pongo mi descuento
        this.porcDescuento = desc;
    }

    public double getDescuento(){
        return this.porcDescuento;
    }

    @Override
    protected double getBaseImponible() {
        return super.getBaseImponible() - (super.getBaseImponible() * (porcDescuento / 100));
    }

    @Override
    public String toString() {
        // (autor; título; precioBase; porcentajeOferta; baseImponible; porcentajeIva; precioFinal)
        return String.format("(%s; %s; %.2f; %.2f%%; %.2f; %.2f; %.2f)",
                getAutor(), // super.getAutor()
                getTitulo(),
                getPrecioBase(),
                porcDescuento,
                getBaseImponible(),
                Libro.getIVA(), // o super.getIVA() o getIVA() o this.getIVA()
                getPrecioFinal());
    }
}
