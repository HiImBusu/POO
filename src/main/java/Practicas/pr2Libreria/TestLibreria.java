package Practicas.pr2Libreria;

public class TestLibreria {
    public static void main(String[] args) {
        Libreria lib = new Libreria();

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

        System.out.println("-- Lista inicial");
        System.out.println(lib);

        System.out.println("-- Eliminando libros");
        lib.remLibro("George Orwell", "1984");
        lib.remLibro("Aldous Huxley", "Un Mundo Feliz");
        lib.remLibro("Isaac Newton", "Arithmetica Universalis");
        System.out.println(lib);

        System.out.println("-- Imprimiendo precios finales");
        String aut = "Philip K. Dick";
        String tit = "¿Sueñan los androides con ovejas eléctricas?";
        System.out.printf("PrecioFinal(%s, %s): %.2f\n", aut, tit, lib.getPrecioFinal(aut, tit));
        aut = "isaac asimov";
        tit = "fundación e imperio";
        System.out.printf("PrecioFinal(%s, %s): %.2f\n", aut, tit, lib.getPrecioFinal(aut, tit));
        aut = "Isaac Newton";
        tit = "Arithmetica";
        System.out.printf("PrecioFinal(%s, %s): %.2f\n", aut, tit, lib.getPrecioFinal(aut, tit));
    }
}
