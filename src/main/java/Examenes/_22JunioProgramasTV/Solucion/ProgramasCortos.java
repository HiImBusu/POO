package Examenes._22JunioProgramasTV.Solucion;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class ProgramasCortos implements SugerenciasTV{
    private int dr;
    public ProgramasCortos(int duracionReferencia){
        dr = duracionReferencia;
    }
    @Override
    public SortedSet<ProgramaTV> sugerencias(Collection<ProgramaTV> progs) {
        SortedSet<ProgramaTV> filtro = new TreeSet<>(new OrdenAlternativoProgramaTV());
        for(ProgramaTV p : progs){
            if(p.getDuracion() <= dr){
                filtro.add(p);
            }
        }
        return filtro;
    }
}
