package Conceptos.Herencia;

public class Test {
    public static void main(String[] args) {
        // -- Herencia: Una clase puede HEREDAR los atributos y el comportamiento de una clase padre
        // A partir de la clase Punto generar las siguientes clases:
        // Pincel: Punto CON GROSOR (double)
        // Pincel(double, double, double)
        // Pincel(double, double)
        // Pincel()
        // Pincel(Pincel)
        // getGrosor(): double
        // setGrosor(double): void
        // @override trasladar(double incx, double incY): Traslada el punto y reduce en un 1% el grosor del pincel
        // @override toString(): "x, y, grosor"


        // Otro ejemplo:
        // Alumno (nombre, edad, grado)
        // Profesor (nombre, edad, asignatura)
        // Denominador comun: Persona (nombre, edad)
        Pincel p = new Pincel(1, 2, 0.4);
        Punto p1 = new Punto(2, 3);


        Punto p2 = new Pincel(1, 2, 4);
        System.out.println(p2.toString());



    }
}
