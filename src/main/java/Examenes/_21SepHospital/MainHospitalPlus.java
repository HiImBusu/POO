package Examenes._21SepHospital;

import Examenes._21SepHospital.Solucion.Hospital;
import Examenes._21SepHospital.Solucion.HospitalException;
import Examenes._21SepHospital.Solucion.HospitalPlus;
import Examenes._21SepHospital.Solucion.Patient;

import java.util.SortedMap;
import java.util.SortedSet;

public class MainHospitalPlus {
    public static void main(String[] args) {
        try{
            HospitalPlus h = new HospitalPlus("Carlos haya", 3, 5);

            System.out.println("\n-- Cargamos los pacientes");
            h.readPatients("src\\main\\java\\Examenes\\_21SepHospital\\patients.txt");
            System.out.println(h);

            System.out.println("\n-- Pacientes por añó");
            SortedMap<Integer, SortedSet<Patient>> map = h.patientsPerYear();
            System.out.println(map);

            System.out.println("\n-- Nº de pacientes por año");
            SortedMap<Integer, Integer> map2 = h.numberOfPatientsPerYear();
            System.out.println(map2);

        }catch(HospitalException ex){
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
