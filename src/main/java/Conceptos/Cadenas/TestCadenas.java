package Conceptos.Cadenas;

import Practicas.pr2Libreria.Libro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class TestCadenas {
    public static void main(String[] args) {
        // Formateo de cadenas: String.format(...)
        String cadena = "Hola";
        int numero = 4;
        double pi = 3.14;
        // %s: cadena
        // %d: int
        // %f: float/double.
        //      Variaciones:
        //          %5f: Siempre con 5 caracteres
        //          %.2f: Con dos decimales
        System.out.println(String.format("%s; %d; %5.2f", cadena, numero, pi));
        System.out.println(String.format("%s; %d; %10.2f", cadena, numero, 1234.45567));
        System.out.println(String.format("%s; %d; %5.2f", cadena, numero, 0.02));

        // ¿Concatenacion de cadenas?
        String cad = "";
        System.out.println("Inicio");
        for(int i = 0; i < 1000000; i++){
            // cad += Integer.toString(i); MAL!!!!!!!!
        }
        System.out.println("Fin");


        // Para hacer concatenaciones
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            sb.append(Integer.toString(i) + " ");
        }
        System.out.println(sb.toString());


        // Para juntar varios strings mediante algun separador
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for(int i = 0; i < 10; i++){
            sj.add(Integer.toString(i));
        }
        System.out.println(sj.toString());


        // Para imprimir un array
        // 1. Array primitivo
        String[] arrayStringsPrimitivo = {"Hola", "esto", "es", "una", "prueba"};
        System.out.println(arrayStringsPrimitivo.toString()); // MAL!!!!!!
        System.out.println(Arrays.toString(arrayStringsPrimitivo)); // OK

        String[] lista = {"Hola", "esto", "es", "una", "prueba"};
        StringJoiner sj1 = new StringJoiner("; ", "[", "]");
        for(String c : lista){
            sj1.add(c);
        }
        System.out.println(sj1.toString());
        System.out.println("-- Otra forma");
        System.out.println(Arrays.toString(lista));


        // 2. ArrayList
        ArrayList<Libro> listaA = new ArrayList<>();
        listaA.add(new Libro("aut1", "tit1", 10));
        listaA.add(new Libro("aut2", "tit2", 20));
        System.out.println(listaA.toString());


    }
}
