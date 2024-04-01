package Practicas.pr1Jarras;

public class EjemploUsoJarras1 {
    public static void main(String[] args) {
        Jarra jA = new Jarra(7);
        Jarra jB = new Jarra(4);
        jA.llena();
        System.out.println(jA + ", " + jB);

        jB.llenaDesde(jA);
        System.out.println(jA + ", " + jB);

        jB.vacia();
        System.out.println(jA + ", " + jB);

        jB.llenaDesde(jA);
        System.out.println(jA + ", " + jB);
    }
}
