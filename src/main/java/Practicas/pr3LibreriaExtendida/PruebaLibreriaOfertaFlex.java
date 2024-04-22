package Practicas.pr3LibreriaExtendida;

import java.util.ArrayList;

public class PruebaLibreriaOfertaFlex {
    public static void main(String[] args) {
        OfertaFlex of = new OfertaAutor(0.2, new String[] {"George Orwell", "Isaac Asimov"});
        OfertaFlex of2 = new OfertaPrecio(0.3, 100);
        LibreriaOfertaFlex lib = new LibreriaOfertaFlex(of);
        lib.addLibro("george orwell", "1984", 8.20);
        lib.addLibro("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?", 3.50);
        lib.addLibro("Isaac Asimov", "Fundación e Imperio", 9.40);
        lib.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
        lib.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
        lib.addLibro("Isaac Asimov", "La Fundación", 7.30);
        lib.addLibro("William Gibson", "Neuromante", 8.30);
        lib.addLibro("Isaac Asimov", "Segunda Fundación", 8.10);
        lib.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
        lib.addLibro("George Orwell", "1984", 6.20);
        lib.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);

        System.out.println("-- Insertando los libros");
        System.out.println(lib);

        System.out.println("\n-- Eliminar los libros");

        lib.remLibro("George Orwell", "1984");
        lib.remLibro("Aldous Huxley", "Un Mundo Feliz");
        lib.remLibro("Isaac Newton", "Arithmetica Universalis");
        System.out.println(lib);


        System.out.printf("PrecioFinal(Philip K. Dick, ¿Sueñan los androides con ovejas eléctricas?): %.2f",
                lib.getPrecioFinal("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?"));

        System.out.println("PrecioFinal(isaac asimov, fundación e imperio):" +
                lib.getPrecioFinal("isaac asimov", "fundación e imperio"));

    }
}
