package Examenes._19SepGasolinera.Solucion;

import java.util.Comparator;

public class TicketOrdenAlternativo implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        int comp = Integer.compare(o2.getNumTicket(), o1.getNumTicket());
        if(comp == 0)
            comp = o1.getGasolinera().compareToIgnoreCase(o2.getGasolinera());
        return comp;
    }
}
