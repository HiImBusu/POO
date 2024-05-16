package Examenes._22JunioProgramasTV.Solucion;

import java.util.Comparator;

public class OrdenAlternativoProgramaTV implements Comparator<ProgramaTV> {
    @Override
    public int compare(ProgramaTV o1, ProgramaTV o2) {
        int comp = o1.getNombre().compareToIgnoreCase(o2.getNombre());
        if(comp == 0)
            comp = Integer.compare(o1.getDuracion(), o2.getDuracion());
        if(comp == 0)
            comp = o1.getHoraInicio().compareTo(o2.getHoraInicio());
        return comp;
    }
}
