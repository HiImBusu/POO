package Examenes._17SepRedSocial;

import Examenes._17SepRedSocial.Solucion.*;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        try{
            System.out.println("-- Prueba 1: Crear la red social vacia");
            RedSocial r = new RedSocial();
            System.out.println(r);


            System.out.println("\n-- Cargo los mensajes del fichero");
            r.cargarDeFichero("src\\main\\java\\Examenes\\_17SepRedSocial\\entrada.txt");
            System.out.println(r);

            System.out.println("\n-- Me logeo como el Usuario1 y compruebo mis mensajes al Usuario3");
            r.login("Usuario1");
            System.out.println(r.getMsjsCon("Usuario3"));
            r.logout();

            System.out.println("\n-- Me logeo como el Usuario1 y busco los mensajes del Usuario 1 que contengan la palabra 'holis' o 'marco'");
            r.login("Usuario1");
            System.out.println(r.getMsjsClaves(Set.of("holis", "marco")));
            r.logout();

            System.out.println("\n-- Creo una cuenta moderada e intento meterle un mensaje prohibido");
            r.crearCuentaModerada("UsuarioModerado", Set.of("idiota"));
            r.login("UsuarioModerado");
            r.addMsj("Usuario1", "si suspendes programacion avanzada eres idiota!");
            r.addMsj("Usuario1", "si suspendes programacion avanzada eres menos inteligente!");
            System.out.println(r);
            r.logout();


            System.out.println("\n-- Guardo los mensajes en un fichero");
            r.guardarEnFichero("src\\main\\java\\Examenes\\_17SepRedSocial\\salida.txt");
            System.out.println("Guardado correctamente!");

        }catch (Exception ex){
            ex.printStackTrace();
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
