package Examenes._19JunioRegistroCivil.Solucion;

public class FiltroGeneroInicial implements Filtro{
    private char genero, inicial;
    public FiltroGeneroInicial(char gen, char ini){
        this.genero = gen;
        this.inicial = ini;
    }

    @Override
    public boolean criterio(Nombre n) {
        return this.genero == n.getGenero() && this.inicial == n.getNombre().charAt(0);
    }
}
