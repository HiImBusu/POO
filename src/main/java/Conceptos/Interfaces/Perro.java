package Conceptos.Interfaces;

public class Perro implements Animal{
    @Override
    public void hacerSonido() {
        System.out.println("El perro ladra");
    }

    @Override
    public void moverse() {
        System.out.println("El perro se mueve");
    }
}
