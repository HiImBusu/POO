package Examenes._19JunioPatinetes.Solucion;

public class SeleccionAutonomia implements Seleccion{
    private double umbral;
    public SeleccionAutonomia(double umbral){
        this.umbral = umbral;
    }

    @Override
    public boolean seleccionar(Patinete p) {
        return p.getAutonomia() < this.umbral;
    }
}
