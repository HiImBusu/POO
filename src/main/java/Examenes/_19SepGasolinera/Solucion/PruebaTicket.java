package Examenes._19SepGasolinera.Solucion;

import java.util.*;

public class PruebaTicket {
    public static void main(String[] args) {
        try{
            Ticket t1 = new Ticket(1, "Teatinos", "1111aaa", 50, 1.40);
            Ticket t2 = new Ticket(1, "TEATINOS", "1111AAA", 45, 2.40);
            Ticket t3 = new Ticket(2, "Teatinos", "2222BBB", 50, 1.40);
            Ticket t4 = new Ticket(1, "Ampliacion", "3333CCC", 40, 1.30);

            System.out.println(t1);
            System.out.println(t2);
            if(t1.equals(t2)){
                System.out.println("Son iguales");
            }else{
                System.out.println("Son distintos");
            }
            SortedSet<Ticket> conj = new TreeSet<>();
            conj.add(t1);
            conj.add(t2);
            conj.add(t3);
            conj.add(t4);
            System.out.println("\nTickets ordenados por orden natural: ");
            System.out.println(conj);

            SortedSet<Ticket> conj_alt = new TreeSet<>(new TicketOrdenAlternativo());
            conj_alt.add(t1);
            conj_alt.add(t2);
            conj_alt.add(t3);
            conj_alt.add(t4);
            System.out.println("\nTickets ordenados por orden alternativo: ");
            System.out.println(conj_alt);

            Ticket t5 = new Ticket(10, "BLA BLA", "BLA BLA", -10, 2.0);

        }catch (GasolineraException ex){
            System.err.printf("ERROR: %s", ex.getMessage());
        }
    }
}
