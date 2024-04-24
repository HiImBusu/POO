package Examenes._19SepGasolinera.Solucion;

import java.util.Locale;

public class Ticket implements Comparable<Ticket>{
    private int numero;
    private String nombreGasolinera;
    private String matriculaVehiculo;
    private double litros;
    private double precioLitro;
    private boolean facturado;

    public Ticket(int num, String nG, String mV, double lit, double preL){
        if(preL <= 0 || lit <= 0 || mV.isEmpty() || mV.isBlank() || nG.isEmpty() || nG.isBlank())
            throw new GasolineraException("Valores incorrectos para crear un ticket");

        this.numero = num;
        this.nombreGasolinera = nG;
        this.matriculaVehiculo = mV;
        this.litros = lit;
        this.precioLitro = preL;
        this.facturado = false;
    }

    public int getNumTicket() {
        return numero;
    }

    public double getNumLitros() {
        return litros;
    }

    public String getGasolinera() {
        return nombreGasolinera;
    }
    public boolean getFacturado(){
        return facturado;
    }

    public void setFacturado(boolean facturado) {
        this.facturado = facturado;
    }
    public double precioTotal(){
        return precioLitro * litros;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Ticket t) && this.nombreGasolinera.equalsIgnoreCase(t.nombreGasolinera) &&
                this.numero == t.numero;
    }


    @Override
    public int compareTo(Ticket o) {
        int comp = this.nombreGasolinera.compareToIgnoreCase(o.nombreGasolinera);
        if(comp == 0)
            comp = Integer.compare(this.numero, o.numero);
        return comp;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "Ticket: %d (gasolinera: %s, matricula: %s, litros: %.1f, PRECIO = %.1f",
                numero, nombreGasolinera, matriculaVehiculo, litros, precioTotal());
    }
}
