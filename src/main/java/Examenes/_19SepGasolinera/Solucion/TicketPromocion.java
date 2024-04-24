package Examenes._19SepGasolinera.Solucion;

public class TicketPromocion extends Ticket{
    private double descuento;

    public TicketPromocion(int numero, String gaso, String matri, double litros, double precio_litro, double desc){
        super(numero, gaso, matri, litros, precio_litro);
        this.descuento = desc;
    }

    @Override
    public double precioTotal() {
        return super.precioTotal() - (super.precioTotal() * descuento);
    }

    @Override
    public String toString() {
        return String.format("PROMOCION %.1f%%: %s", this.descuento * 100, super.toString());
    }
}
