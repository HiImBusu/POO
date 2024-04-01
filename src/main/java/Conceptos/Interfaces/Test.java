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
        Perro perro = new Perro();
        Pajaro pajaro = new Pajaro();
        perro.hacerSonido();
        pajaro.hacerSonido();



    }
}
