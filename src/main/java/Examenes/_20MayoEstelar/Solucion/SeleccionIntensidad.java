package Examenes._20MayoEstelar.Solucion;

public class SeleccionIntensidad implements Seleccion{
    private double min, max;
    public SeleccionIntensidad(double minimo, double maximo){
        this.min = minimo;
        this.max = maximo;
    }

    @Override
    public boolean seleccionar(Estrella e) {
        return e.getMagnitud() >= min && e.getMagnitud() <= max;
    }
}
