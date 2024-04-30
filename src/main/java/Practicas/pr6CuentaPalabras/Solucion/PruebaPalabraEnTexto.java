package Practicas.pr6CuentaPalabras.Solucion;

public class PruebaPalabraEnTexto {
    public static void main(String[] args) {
        PalabraEnTexto p1 = new PalabraEnTexto("gorra");
        PalabraEnTexto p2 = new PalabraEnTexto("Gorra");
        p1.incrementa();
        System.out.printf("Palabra 1 = %s\n", p1);
        System.out.printf("Palabra 2 = %s\n", p2);
        if(p1.equals(p2)){
            System.out.println("Las palabras son iguales");
        }else{
            System.out.println("Las palabras son distintas");
        }
    }
}
