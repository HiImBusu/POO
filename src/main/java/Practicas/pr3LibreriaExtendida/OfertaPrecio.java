package Practicas.pr3LibreriaExtendida;

public class OfertaPrecio implements OfertaFlex{
    // Atributos
    private double porcDescuento;
    private double umbralPrecio;

    // Metodos
    public OfertaPrecio(double porc, double umb){
        porcDescuento = porc;
        umbralPrecio = umb;
    }

    @Override
    public double getDescuento(Libro lib) {
        double desc = 0.0;
        // si el precio base del libro es mayor o igual al umbral especificado
        if(lib.getPrecioBase() >= umbralPrecio){
            desc = porcDescuento;
        }
        return desc;
    }

    @Override
    public String toString() {
        // 20.0%(8)
        return String.format("%.2f%%(%f)", porcDescuento * 100, umbralPrecio);
    }
}
