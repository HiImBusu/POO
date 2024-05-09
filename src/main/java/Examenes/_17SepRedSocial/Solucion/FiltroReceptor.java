package Examenes._17SepRedSocial.Solucion;

public class FiltroReceptor implements Filtro{
    private String receptor;
    public FiltroReceptor(String recep){
        this.receptor = recep;
    }

    @Override
    public boolean select(Mensaje m) {
        return m.getReceptor().equalsIgnoreCase(this.receptor);
    }
}
