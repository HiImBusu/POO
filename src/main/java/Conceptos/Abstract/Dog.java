package Conceptos.Abstract;

public class Dog extends Animal{
    public Dog(int e, String n){
        this.age = e;
        this.name = n;
    }
    public void ladrar(){
        System.out.println("El perro ladra");
    }

    @Override
    public void makeNoise() {
        System.out.println("Ladra!");
    }
}
