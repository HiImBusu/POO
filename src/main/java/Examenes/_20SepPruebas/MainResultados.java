package Examenes._20SepPruebas;

import Examenes._20SepPruebas.Solucion.Practica;
import Examenes._20SepPruebas.Solucion.Resultados;
import Examenes._20SepPruebas.Solucion.SelectorNombre;
import Examenes._20SepPruebas.Solucion.SelectorUmbralExito;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MainResultados {
    public static void main(String[] args) throws IOException {
        Resultados r = new Resultados(Set.of(
                new Practica("Practica", "pr1", 35, 0),
                new Practica("Practica", "pr2", 45, 0),
                new Practica("Practica", "pr3", 55, 0)));

        System.out.println("-- Prueba 1");
        r.cargarDeFichero("src\\main\\java\\Examenes\\_20SepPruebas\\datos.txt");
        System.out.println(r);


        System.out.println("\n-- Prueba 2");
        r.completarPracticas();
        System.out.println(r);

        System.out.println("\n-- Prueba 3");
        Resultados r2 = r.seleccionar(new SelectorNombre(Set.of("ana luisa", "maria luisa")));
        System.out.println(r2);

        System.out.println("\n-- Prueba 4");
        Resultados r3 = r.seleccionar(new SelectorUmbralExito(20));
        System.out.println(r3);

        System.out.println("\n-- Prueba 5");
        r.guardarEnFichero("src\\main\\java\\Examenes\\_20SepPruebas\\salida.txt");
        System.out.println("Fichero generado correctamente!");

        System.out.println("\n-- Prueba 6");
        r.anyadirPractica(new Practica("xxx", "xxx"));

        System.out.println("Fin de ejecucion");
    }
}
