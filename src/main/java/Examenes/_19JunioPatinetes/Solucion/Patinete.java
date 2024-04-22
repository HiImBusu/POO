package Examenes._19JunioPatinetes.Solucion;

import Examenes._19JunioPatinetes.Posicion;

public class Patinete implements Comparable<Patinete>{
    private String nombreEmpresa;
    private int codigo;
    private Posicion posicion;
    private double autonomia;
    public Patinete(String ne, int cod, Posicion pos, double auto) throws PatinetesException {
        if(cod < 0 || auto < 0)
            throw new PatinetesException("Autonomia negativa al crear Patinete");

        this.nombreEmpresa = ne;
        this.codigo = cod;
        this.posicion = pos;
        this.autonomia = auto;
    }

    public Patinete(String ne, int cod, Posicion pos) throws PatinetesException {
        this(ne, cod, pos, 0);
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public int getCodigo() {
        return codigo;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void setAutonomia(double autonomia) throws PatinetesException {
        if(autonomia < 0)
            throw new PatinetesException("Valor negativo al modificar la autonomia");
        this.autonomia = autonomia;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Patinete p) && this.nombreEmpresa.equalsIgnoreCase(p.nombreEmpresa) && this.codigo == p.codigo;
    }

    @Override
    public int compareTo(Patinete o) {
        int comp = this.nombreEmpresa.compareToIgnoreCase(o.nombreEmpresa);
        if(comp == 0)
            comp = Integer.compare(this.codigo, o.codigo);
        return comp;
    }

    @Override
    public String toString() {
        return String.format("(Empresa: %s; Codigo: %d; %s; Autonomia: %.1f",
                this.nombreEmpresa, this.codigo, this.posicion, this.autonomia);
    }
}
