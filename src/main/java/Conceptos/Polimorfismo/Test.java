package Conceptos.Polimorfismo;

import java.util.ArrayList;

public class Test {
    // -- Polimorfismo: Un puntero a una clase puede tomar MULTIPLES FORMAS (debe de ser una clase hija del tipo del puntero)
    //              B (Override(mA), mB) - D (mD)
    // A (ma)   /
    //          \
    //              C (mC)
    public static void main(String[] args) {
        System.out.println("-- Llamamos a los metodos de las clases por separado");
        System.out.println("-- A");
        A a = new A();
        a.mA();

        System.out.println("-- B");
        B b = new B();
        b.mA();
        b.mB();

        System.out.println("-- C");
        C c = new C();
        c.mA();
        c.mC();

        System.out.println("-- D");
        D d = new D();
        d.mA();
        d.mB();
        d.mD();

        System.out.println("-- Utilizando el polimorfismo creamos un array de la clase padre (A), donde " +
                "meteremos instancias de clases que hereden directa o indirectamente de la clase (A)");
        ArrayList<A> listaComun = new ArrayList<>();
        listaComun.add(new A());
        listaComun.add(new B());
        listaComun.add(new C());
        listaComun.add(new D());

        System.out.println("-- Invocamos al metodo mA ya que es el unico que tiene definido el padre!!. " +
                "Pero en funcion de la instancia sobre la que se encuentre cogera la implementacion de la clase adecuada");
        for(A item : listaComun){
            item.mA();
        }
    }
}
