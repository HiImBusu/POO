package Examenes._20MayoEstelar.Solucion;

import java.util.Objects;

public class Estrella implements Comparable<Estrella>{
    private double magnitud;
    private String nombre;
    private String observatorio;

    public Estrella(String nom, String obs) throws EstrellaException {
        this(nom, obs, 0.0);
    }

    public Estrella(String nom, String obs, double mag) throws EstrellaException {
        if(nom == null || nom.isEmpty() || nom.isBlank())
            throw new EstrellaException("Nombre no valido");
        if(obs == null || obs.isEmpty() || obs.isBlank())
            throw new EstrellaException("Observatorio no valido");
        if(mag < 0.0)
            throw new EstrellaException("Magnitud luminosa negativa");
        this.nombre = nom;
        this.observatorio = obs;
        this.magnitud = mag;
    }

    public String getObservatorio() {
        return observatorio;
    }

    public double getMagnitud() {
        return magnitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setMagnitud(double magnitud) {
        this.magnitud = magnitud;
    }

    @Override
    public String toString() {
        return String.format("(%s;%s;%.1f)", nombre, observatorio, magnitud);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Estrella e) &&
                this.nombre.equalsIgnoreCase(e.nombre) &&
                this.observatorio.equalsIgnoreCase(e.observatorio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }

    @Override
    public int compareTo(Estrella o) {
        int comp = nombre.compareToIgnoreCase(o.nombre);
        if(comp == 0)
            comp = observatorio.compareToIgnoreCase(o.observatorio);
        return comp;
    }
}
