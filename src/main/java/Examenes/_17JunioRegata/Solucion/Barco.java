package Examenes._17JunioRegata.Solucion;
import Examenes._17JunioRegata.Posicion;

public class Barco implements Comparable<Barco>{
    protected String nombre;
    protected Posicion posicion;
    protected int rumbo;
    protected int velocidad;

    public Barco(String nom, Posicion pos, int rum, int vel){
        if(rum < 0 || rum > 359)
            throw new RegataException("Rumbo no valido");

        this.nombre = nom;
        this.posicion = pos;
        this.rumbo = rum;
        this.velocidad = vel;
    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getRumbo() {
        return rumbo;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Barco b) &&
                this.nombre.equalsIgnoreCase(b.nombre);
    }

    @Override
    public int compareTo(Barco o) {
        return this.nombre.compareToIgnoreCase(o.nombre);
    }

    public void avanza(int mnt){
        this.posicion = this.posicion.posicionTrasRecorrer(mnt, this.rumbo, this.velocidad);
    }

    @Override
    public String toString() {
        return String.format("%s: %s R= %d V= %d", this.nombre, this.posicion, this.rumbo, this.velocidad);
    }
}
