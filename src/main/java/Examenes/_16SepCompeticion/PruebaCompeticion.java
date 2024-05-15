package Examenes._16SepCompeticion;

import Examenes._16SepCompeticion.Solucion.Competicion;
import Examenes._16SepCompeticion.Solucion.CompeticionException;
import Examenes._16SepCompeticion.Solucion.CompeticionMaster;

import java.io.FileNotFoundException;

public class PruebaCompeticion {
    public static void main(String[] args) {
        try{
            System.out.println("--- Cargamos una competicion normal");
            Competicion competicion = new Competicion("src\\main\\java\\Examenes\\_16SepCompeticion\\equipos.txt");
            System.out.println(competicion);

            System.out.println("-- Modificamos los partidos jugados/ganados de algunos jugadores");
            competicion.increPartidos("Lucas Ortiz", 5, 2);
            competicion.increPartidos("alberto cuenca", 10, 8);
            System.out.println(competicion);


            System.out.println("-- Escribimos en un fichero el estado actual de la competicion");
            competicion.escribirFichero("src\\main\\java\\Examenes\\_16SepCompeticion\\equiposSalida.txt");
            System.out.println("Fichero creado correctamente!");

            System.out.println("-- Creamos una nueva competicion cargando del fichero con un umbral de corte de 1 (que al menos hayan ganado un partido)");
            CompeticionMaster master = new CompeticionMaster("src\\main\\java\\Examenes\\_16SepCompeticion\\equipos.txt", 1);
            System.out.println(master);


        }catch (FileNotFoundException ex){
            System.out.println("Error: Fichero no encontrado");
        }catch (CompeticionException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    /*
    --- Cargamos una competicion normal
    Centro Padel:2:6
        Lucas Ortiz:1:1
        Alberto Cuenca:1:1
        Victoria Diaz:1:1
        Roberto Gomez:1:1
    Parque Litoral:3:10
        Ana Romero:3:2
        Juan Diaz:2:2
        Antonio Lopez:2:1
        Pedro Jimenez:3:3
        Carmen Perez:1:1
        Luisa Montiel:1:1
    Padel Palo:3:8
        Rosa Lima:2:1
        Jose Atencia:2:1
        Manuel Rodriguez:2:2
        Barbara Avila:2:2
        Alfredo Maroto:1:0
        Ignacio Suarez:1:0

    -- Modificamos los partidos jugados/ganados de algunos jugadores
    Centro Padel:2:6
        Lucas Ortiz:6:3
        Alberto Cuenca:11:9
        Victoria Diaz:1:1
        Roberto Gomez:1:1
    Parque Litoral:3:10
        Ana Romero:3:2
        Juan Diaz:2:2
        Antonio Lopez:2:1
        Pedro Jimenez:3:3
        Carmen Perez:1:1
        Luisa Montiel:1:1
    Padel Palo:3:8
        Rosa Lima:2:1
        Jose Atencia:2:1
        Manuel Rodriguez:2:2
        Barbara Avila:2:2
        Alfredo Maroto:1:0
        Ignacio Suarez:1:0

    -- Escribimos en un fichero el estado actual de la competicion
    Fichero creado correctamente!
    -- Creamos una nueva competicion cargando del fichero con un umbral de corte de 1 (que al menos hayan ganado un partido)
    Centro Padel:2:6
        Lucas Ortiz:1:1
        Alberto Cuenca:1:1
        Victoria Diaz:1:1
        Roberto Gomez:1:1
    Parque Litoral:3:10
        Ana Romero:3:2
        Juan Diaz:2:2
        Antonio Lopez:2:1
        Pedro Jimenez:3:3
        Carmen Perez:1:1
        Luisa Montiel:1:1
    Padel Palo:3:8
        Rosa Lima:2:1
        Jose Atencia:2:1
        Manuel Rodriguez:2:2
        Barbara Avila:2:2
     */
}
