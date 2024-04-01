package Conceptos.Polimorfismo;

import java.util.ArrayList;

public class Test {
    // -- Polimorfismo: Un puntero a una clase puede tomar MULTIPLES FORMAS (debe de ser una clase hija del tipo del puntero)
    //              B (Override(mA), mB) - D (mD)
    // A (ma)   /
    //          \
    //              C (mC)
    public static void main(String[] args) {
        /*
        A a = new A();
        a.mA();

        B b = new B();
        b.mA();

        C c = new C();
        c.mA();

        D d = new D();
        d.mA();
        d.mB();
        d.mD();
         */

        ArrayList<A> listaComun = new ArrayList<>();
        listaComun.add(new A());
        listaComun.add(new B());
        listaComun.add(new C());
        listaComun.add(new D());

        for(A item : listaComun){
            item.mA();
        }
    }
}
