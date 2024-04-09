package Conceptos.Abstract;
/*
    Definicion: Es una clase que por definicion NO SE PUEDE INSTANCIAR

    Uso: Permite definir una serie de ATRIBUTOS y METODOS que las clases que hereden de esta deben de tener

    Diferencias vs interfaz:
        - Una clase SOLO puede tener una herencia, pero puede implementar MULTIPLES interfaces
        - En una interfaz no puedo definir atributos que deben de tener las clases, si los defino esos atributos seran
            "static final", no seran atributos de instancia. Seran atributos de CLASE y por tanto seran comunes para todas
            las instancias de clase y ademas sera constante.

    Ejemplo:
        Clase abstracta: Animal
            Atributos:
                int age
                String name
            Metodos:
                public abstract void makeNoise(); Al poner abstract OBLIGO a que la clase hija debe de implementar este metodo
                public String getName(){ return name; } Al NO poner abstract, puedo hacer la implementacion COMUN en la clase abstracta
       Interfaz: AnimalStuff
            Metodo:
                public void poop();
       Clase base: Cat
            Atributos:
            Metodos:
                override makeNoise()
                override pop();
* */
public class Test {
    public static void main(String[] args) {

    }
}
