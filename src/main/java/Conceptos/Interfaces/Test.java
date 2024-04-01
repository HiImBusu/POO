package Conceptos.Interfaces;

public class Test {
    // -- Interfaz: Define un protocolo de comportamiento que debe de ser IMPLENTADO por
    // cualquier clase que IMPLEMENTE dicha interfaz
    // (I): Animal
    // hacerSonido(): void
    // moverse(): void
    // Clases que implementan dicha interfaz
    // (C): Perro
    // (C): Pajaro
    public static void main(String[] args) {
        System.out.println("-- Creamos el objeto 'Perro' y llamamos a su metodo común 'hacerSonido/moverse'");
        Perro perro = new Perro();
        perro.hacerSonido();
        perro.moverse();
        System.out.println("-- Creamos el objeto 'Pajaro' y llamamos a su metodo a su metodo común 'hacerSonido/moverse'");
        Pajaro pajaro = new Pajaro();
        pajaro.hacerSonido();
        pajaro.moverse();
    }
}
