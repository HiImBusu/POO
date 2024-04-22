package Conceptos.Abstract;

public abstract class Animal {
    protected int age;
    protected String name;

    public int getAge() {
        return age;
    }

    public abstract void makeNoise();
}
