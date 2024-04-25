package Examenes._21SepHospital;

import Examenes._21SepHospital.Solucion.HospitalException;
import Examenes._21SepHospital.Solucion.Patient;

public class MainPatient {
    public static void main(String[] args) {
        try{
            System.out.println("-- Creamos algunos pacientes");
            Patient p1 = new Patient("Luis", "Amador", "0812345694", 1994);
            Patient p2 = new Patient("Ana", "Garcia", "0465432167", 2000);
            Patient p3 = new Patient("Jose", "Perez", "0465426107", 2002);
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);

            System.out.println("\n-- Comparamos igualdad");
            Patient p4 = new Patient("jose", "perez", "0465426107", 2002);
            if(p3.equals(p4)){
                System.out.println("Son iguales");
            }else{
                System.out.println("Son distintos");
            }

            System.out.println("\n-- Comparamos ordenacion");
            int comp = p1.compareTo(p2);
            if(comp < 0)
                System.out.println("p1 es menor que p2");
            else if(comp == 0)
                System.out.println("p1 es igual que p2");
            else
                System.out.println("p1 es mayor que p2");

        } catch (HospitalException ex){
            System.err.println("Error: " + ex.getMessage());
        }

    }
}
