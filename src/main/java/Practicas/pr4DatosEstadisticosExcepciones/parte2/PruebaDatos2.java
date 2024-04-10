package Practicas.pr4DatosEstadisticosExcepciones.parte2;

import Practicas.pr4DatosEstadisticosExcepciones.parte1.Datos;
import Practicas.pr4DatosEstadisticosExcepciones.parte1.DatosException;

import java.util.Arrays;

public class PruebaDatos2 {
    public static void main(String[] args) {
        try{
            if(args.length < 2)
                throw new Practicas.pr4DatosEstadisticosExcepciones.parte1.DatosException();

            Practicas.pr4DatosEstadisticosExcepciones.parte1.Datos datos = new Datos(
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
