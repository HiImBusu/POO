package Conceptos.Abstract;

public class Cat extends Animal{
    // Atributos


    // Metodos
    public Cat(int e, String n){
        this.age = e;
        this.name = n;
    }

    public void maullar(){
        System.out.println("El gato maulla");
    }

    @Override
    public void makeNoise() {
        System.out.println("Maulla!");
    }
}
