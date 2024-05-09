package Examenes._17JunioRegata;

import Examenes._17JunioRegata.Solucion.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main3 {
	public static void main(String [] args) {

		Regata regata = new Regata();
		try {
			regata.leeFichero("src\\main\\java\\Examenes\\_17JunioRegata\\barcos.txt");
			PrintWriter out = new PrintWriter(System.out,true);
			regata.escribe(out);
			regata.avanza(10);
			regata.escribeFichero("src\\main\\java\\Examenes\\_17JunioRegata\\salida.txt");
			regata.escribe(out);		
		} catch (FileNotFoundException e) {
			System.err.println("error de E/S " + e.getMessage());
		}


	}
}
