package Examenes._20MayoEstelar.Solucion;

import java.io.FileNotFoundException;

public class TestConstelacion {
    public static void main(String[] args) {
        try{

            System.out.println("-- Leemos del fichero");
            Constelacion c2 = new Constelacion("src\\main\\java\\Examenes\\_20MayoEstelar\\observaciones.txt");
            System.out.println(c2);

            System.out.println("\n-- Pruebas del PDF");
            Constelacion c = new Constelacion();
            c.anyadeEstrellas(new Estrella("Sirius", "Teide", 0.34));
            c.anyadeEstrellas(new Estrella("Rigel", "Roque de los Muchachos", 0.45));
            c.anyadeEstrellas(new Estrella("Sirius", "Mauna Kea", 0.15));
            c.anyadeEstrellas(new Estrella("Sirius", "Roque de los Muchachos", 0.16));
            System.out.println(c);

            System.out.println("Magnitud media de 'Sirius': " + c.magnitudMedia("Sirius"));

            System.out.println("Agrupamiento Roque de los Muchachos: " + c.getAgrupamiento(new SeleccionObservatorio("Roque de los Muchachos")));
            System.out.println("Agrupamiento Intensidad (0.2, 0.4): " + c.getAgrupamiento(new SeleccionIntensidad(0.2, 0.4)));

            c.anyadeEstrellas(new Estrella("Vega", "Mauna kea", -0.4));

        }catch (FileNotFoundException | EstrellaException ex){
            System.err.println("Error: " + ex.getMessage());
        }

    }
}
