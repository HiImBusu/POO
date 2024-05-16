package Examenes._22JunioProgramasTV;

import Examenes._22JunioProgramasTV.Solucion.ProgramacionTV;
import Examenes._22JunioProgramasTV.Solucion.ProgramacionTVException;
import Examenes._22JunioProgramasTV.Solucion.ProgramacionTVPublicidad;
import Examenes._22JunioProgramasTV.Solucion.ProgramasCortos;

import java.io.IOException;
import java.io.PrintWriter;

public class PruebaProgramacionTV {
    public static void main(String[] args) throws IOException {
        // Variable para almacenar una parrilla de programación
        ProgramacionTV parrilla;
        // Se inicialza parrilla con los datos del fichero programacion.txt
        //parrilla = crearParrilla("src\\main\\java\\Examenes\\_22JunioProgramasTV\\programacion.txt");
        parrilla = crearParrillaPublicidad("src\\main\\java\\Examenes\\_22JunioProgramasTV\\programacion.txt");
        try {
            // Se muestra la información de la parrilla en la consola de salida
            parrilla.mostrarProgramas(new PrintWriter(System.out, true));
            // Se guarda la informaci ́no en el fichero parrilla.txt
            parrilla.mostrarProgramas("src\\main\\java\\Examenes\\_22JunioProgramasTV\\salida.txt");
            // Se consulta la consistencia de la parrilla de "LaSexta", que debe ser false
            // Para que sea consistente basta eliimnar la última línea del fichero.
            consistencia(parrilla, "LaSexta");
            // Se consulta la consistencia de la parrilla de "A3", que debe ser true
            consistencia(parrilla, "A3");
            // Se consulta la consistencia de la parrilla de "Cuatro", que debe producir una
            // excepción, porque la cadena Cuatro no está en la parrilla.
            consistencia(parrilla, "Cuatro");
        } catch (ProgramacionTVException pe) {
            System.err.println(pe.getMessage());
        }
        // Se seleccionan los programas que tienen 30 minutos o menos
        System.out.println("Los programas de menos de media hora son: \n" +
                parrilla.sugerencias(new ProgramasCortos(30)));
    }

    /*
    -- Esto debe de salir con la programacion normal
    A3:
        NOTICAS A3@[15:00]-30
        SERIES TURCAS@[17:00]-60
        EL HORMIGUERO@[21:30]-45
    LaSexta:
        LA SEXTA NOTICAS@[14:30]-30
        DEBATES QUE NO VE NADIE@[16:00]-60
        EL CHIRINGUITO@[16:45]-60
    La cadena LaSexta no es consistente
    La cadena A3 es consistente
    Los programas de menos de media hora son:
    [LA SEXTA NOTICAS@[14:30]-30, NOTICAS A3@[15:00]-30]
    La cadena no se encuentra

    -- Esto debe de salir con la programacion con anuncios
    A3:
        NOTICAS A3@[15:00]-30
        PUBLICIDAD@[15:30]-5
        SERIES TURCAS@[17:00]-60
        PUBLICIDAD@[18:00]-5
        EL HORMIGUERO@[21:30]-45
        PUBLICIDAD@[22:15]-5
    LaSexta:
        LA SEXTA NOTICAS@[14:30]-30
        PUBLICIDAD@[15:00]-5
        DEBATES QUE NO VE NADIE@[16:00]-60
        EL CHIRINGUITO@[16:45]-60
        PUBLICIDAD@[17:00]-5
        PUBLICIDAD@[17:45]-5
    La cadena LaSexta no es consistente
    La cadena A3 es consistente
    Los programas de menos de media hora son:
    [LA SEXTA NOTICAS@[14:30]-30, NOTICAS A3@[15:00]-30, PUBLICIDAD@[15:00]-5, PUBLICIDAD@[15:30]-5, PUBLICIDAD@[17:00]-5, PUBLICIDAD@[17:45]-5, PUBLICIDAD@[18:00]-5, PUBLICIDAD@[22:15]-5]
    La cadena no se encuentra
     */


    /**
     * Devuelve un objeto ParrillaTV a partir de la información almacenada
     * en el fichero que se pasa como argumento
     * @return Una ParrillaTV
     * @throws IOException
     */
    private static ProgramacionTV crearParrilla(String fichero) throws IOException {
        ProgramacionTV res = new ProgramacionTV();
        res.leerProgramas(fichero);
        return res;
    }
    /**
     * Devuelve un objeto ParrillaTVPublicidad a partir de la información almacenada
     en el fichero
     * @return Una ParrillaTVPublicidad
    a64b0469ff35958ef4ab887a898bd50bdfbbe91a-10290673
    Si has llegado hasta aquí... Te mereces una Mahou
    Reservados todos los derechos. No se permite la explotación económica ni la transformación de esta obra. Queda permitida la impresión en su totalidad.
     * @throws IOException
     */
    private static ProgramacionTV crearParrillaPublicidad(String fichero) throws
            IOException {
        ProgramacionTVPublicidad res = new ProgramacionTVPublicidad();
        res.leerProgramas(fichero);
        return res;
    }
    private static void consistencia(ProgramacionTV parrilla, String cadena) {
        String esNoEs = parrilla.esConsistente(cadena) ? " es " : " no es ";
        System.out.println("La cadena " + cadena + esNoEs + "consistente");
    }
}
