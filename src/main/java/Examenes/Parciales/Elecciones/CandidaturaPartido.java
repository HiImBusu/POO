package Examenes.Parciales.Elecciones;

public class CandidaturaPartido extends Candidatura{
    public CandidaturaPartido(String nomb, String circuns){
        super(nomb, circuns);
    }

    @Override
    public void agregarMiembro(Candidata cand) {
        if(!cand.getPartido().equalsIgnoreCase(getPartido()))
            cand.setPartido(null);
        super.agregarMiembro(cand);
    }

    @Override
    public void agregarCabezaLista(Candidata cand) {
        if(!cand.getPartido().equalsIgnoreCase(getPartido()))
            cand.setPartido(null);
        super.agregarCabezaLista(cand);
    }
}