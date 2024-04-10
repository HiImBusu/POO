package Practicas.pr4DatosEstadisticosExcepciones.parte1;

import java.util.Arrays;

public class PruebaDatos {
    public static void main(String[] args) {
        System.out.println("-------- Prueba 1 ---------------");
        try{
            if(args.length < 2)
                throw new DatosException();

            Datos datos = new Datos(
                    Arrays.copyOfRange(args, 2, args.length),
                    Double.parseDouble(args[0]), Double.parseDouble(args[1]));

            System.out.println("-- Cargamos conjunto de datos inicial");
            System.out.println(datos);

            System.out.println("\n-- Cambiamos el rango a 0;4");
            datos.setRango("0;4");
            System.out.println(datos);

            System.out.println("\n-- Cambiamos el rango a 15 25");
            datos.setRango("15 25");

        }catch (DatosException ex){
            System.out.println(ex.getMessage());
        }catch (NumberFormatException ex){
            System.out.printf("Error, al convertir un valor a número real (%s)", ex.getMessage());
        }
    }
}
