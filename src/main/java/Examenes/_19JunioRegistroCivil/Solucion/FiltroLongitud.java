package Examenes._19JunioRegistroCivil.Solucion;

public class FiltroLongitud implements Filtro{
    private int longitud;
    public FiltroLongitud(int lon){
        this.longitud = lon;
    }

    @Override
    public boolean criterio(Nombre n) {
        return n.getNombre().length() == this.longitud;
    }
}
