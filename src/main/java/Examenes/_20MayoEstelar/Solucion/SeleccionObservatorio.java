package Examenes._20MayoEstelar.Solucion;

public class SeleccionObservatorio implements Seleccion{
    private String observatorio;
    public SeleccionObservatorio(String obs){
        this.observatorio = obs;
    }

    @Override
    public boolean seleccionar(Estrella e) {
        return e.getObservatorio().equalsIgnoreCase(this.observatorio);
    }
}
