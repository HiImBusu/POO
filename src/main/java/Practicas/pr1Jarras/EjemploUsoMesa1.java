package Practicas.pr1Jarras;

public class EjemploUsoMesa1 {
    public static void main(String[] args) {
        // Jarra j1 = new Jarra(7);
        //Jarra j2 = new Jarra(5);
        //Mesa m1 = new Mesa(j1, j2);

        Mesa m1 = new Mesa(7,5);

        m1.llena(Mesa.Posicion.Derecha);
        System.out.println(m1);

        m1.llenaDesde(Mesa.Posicion.Derecha);
        System.out.println(m1);

        m1.llena(Mesa.Posicion.Derecha);
        System.out.println(m1);

        m1.llenaDesde(Mesa.Posicion.Derecha);
        System.out.println(m1);

        m1.vacia(Mesa.Posicion.Izquierda);
        System.out.println(m1);

        m1.llenaDesde(Mesa.Posicion.Derecha);
        System.out.println(m1);

        m1.llena(Mesa.Posicion.Derecha);
        System.out.println(m1);

        m1.llenaDesde(Mesa.Posicion.Derecha);
        System.out.println(m1);
    }
}
