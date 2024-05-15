package Examenes.Parciales.EstudianteCentro;

import Examenes.Parciales.EstudianteCentro.universidad.Estudiante;
import Examenes.Parciales.EstudianteCentro.universidad.EstudianteConBeca;

public class PruebaEstudiantes {
    public static void main(String[] args) {
        // Apartado A.
        // Estudiante e1 = new Estudiante ("785-36-6518", 1, 24, 6.6, false); // ERROR: número de créditos no alcanza el mínimo.
        // System.out.println(e1);

        // Apartado B.
        Estudiante e2 = new Estudiante ("718-15-9116", 2, 24, 6.5, true);
        Estudiante e3 = new Estudiante ("366-35-7779", 1, 66, 8.9, false);
        System.out.println(e2);
        System.out.println(e3);

        // Apartado C.
        Estudiante e4 = new EstudianteConBeca(8.0,"366-35-7779", 1, 66, 8.9, false);
        System.out.println(e4);

    }
}
