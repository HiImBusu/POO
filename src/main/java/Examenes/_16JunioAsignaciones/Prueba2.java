package Examenes._16JunioAsignaciones;

import java.io.FileNotFoundException;
import java.util.Set;
import Examenes._16JunioAsignaciones.Solucion.*;

public class Prueba2 {
	public static void main(String[] args) {
		try{
			System.out.println("Prueba 2");
			System.out.println("--------");
			//Asignamos las peticiones de laboratorio a 2 laboratorios
			Asignaciones pet = new AsignacionesConAlternativas(2,"src\\main\\java\\Examenes\\_16JunioAsignaciones\\peticionesca.txt");
			//Mostramos el resultado de la asignación
			System.out.println(pet);
			//Escribimos en fichero el resultado de la asignación
			pet.escribirAFichero("asignacionesca.txt");
			//Mostramos los huecos libres en un dia/hora determinados
			Set<Integer> libres = pet.buscarHuecos(new FranjaHoraria("Martes", "Primera"));
			System.out.println("Laboratorios libres los Martes a Primera hora: " + libres+"\n");			
		}catch(AsignacionException e){
			System.err.println(e.getMessage());
		}catch(FileNotFoundException e){
			System.err.println("ERROR.Fichero no encontrado");
		}
	}
	/*

	--------------------------
	Laboratorio 1
		(LUNES, PRIMERA) -> POO, Antonio Lopez
		(MARTES, PRIMERA) -> FP, Maria Molina
		(MARTES, SEGUNDA) -> FP1, Juan Perez
		(JUEVES, PRIMERA) -> FP3, Juan Perez
	Laboratorio 2
		(LUNES, PRIMERA) -> FP, Juan Perez
		(MARTES, SEGUNDA) -> FP2, Juan Perez
	Conflictos
	----------

	Laboratorios libres los Martes a Primera hora: [2]

	 */

}