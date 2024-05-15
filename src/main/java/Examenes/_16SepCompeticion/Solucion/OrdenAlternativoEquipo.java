package Examenes._16SepCompeticion.Solucion;

import java.util.Comparator;

public class OrdenAlternativoEquipo implements Comparator<Equipo> {
    @Override
    public int compare(Equipo o1, Equipo o2) {
        int comp = Integer.compare(o1.getCategoria(), o2.getCategoria());
        if(comp == 0)
            comp = o1.getNombre().compareToIgnoreCase(o2.getNombre());
        if(comp == 0)
            comp = Integer.compare(o2.getPuntos(), o1.getPuntos()); // Lo pongo al reves para que el orden sea inverso
        return comp;
    }
}
