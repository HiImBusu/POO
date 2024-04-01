package Conceptos.Interfaces;

public class Pajaro implements Animal{

    @Override
    public void hacerSonido() {
        System.out.println("El pajaro pia");
    }

    @Override
    public void moverse() {
        System.out.println("El pajaro vuela");
    }
}
