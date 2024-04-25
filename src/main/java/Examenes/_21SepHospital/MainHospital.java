package Examenes._21SepHospital;

import Examenes._21SepHospital.Solucion.Hospital;
import Examenes._21SepHospital.Solucion.HospitalException;
import Examenes._21SepHospital.Solucion.Patient;

public class MainHospital {
    public static void main(String[] args) {
        try {
            Hospital h = new Hospital("Carlos haya", 3, 5);
            System.out.println("-- Creamos el hospital vacio");
            System.out.println(h);

            System.out.println("\n-- Cargamos los pacientes");
            h.readPatients("src\\main\\java\\Examenes\\_21SepHospital\\patients.txt");
            System.out.println(h);

            System.out.println("\n-- Hacemos algunos checkIn");
            h.checkIn(new Patient("Ana", "Ramírez", "1234563456", 1992));
            h.checkIn(new Patient("Luis", "Fernández", "2345675420", 1985));
            h.checkIn(new Patient("Sofía", "Gómez", "3456781219", 1974));
            System.out.println(h);

            System.out.println("\n-- Generamos fichero");
            h.writePatients("src\\main\\java\\Examenes\\_21SepHospital\\salida1.txt");
            System.out.println("¿Debe de ser igual que lo que tenemos en salida1Esperada.txt?");

            System.out.println("\n-- Hacemos algunos chekOut");
            h.checkOut("1234563456");
            h.checkOut("2345675420");
            h.checkOut("3456781219");
            h.writePatients("src\\main\\java\\Examenes\\_21SepHospital\\salida2.txt");
            System.out.println("¿Debe de ser igual que lo que tenemos en salida2Esperada.txt?");

        } catch (HospitalException ex) {
            System.err.println("Error: " + ex.getMessage());
        }


    }
}
