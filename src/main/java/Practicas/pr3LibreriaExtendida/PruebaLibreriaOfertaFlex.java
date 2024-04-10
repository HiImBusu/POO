package Practicas.pr3LibreriaExtendida;

public class PruebaLibreriaOfertaFlex {
    public static void main(String[] args) {
        LibreriaOfertaFlex lib = new LibreriaOfertaFlex(
                new OfertaAutor(0.2, new String[]{"George Orwell", "Isaac Asimov"}));

        System.out.println("-- Insertamos los libros");

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
        System.out.println(lib);

    }
}
