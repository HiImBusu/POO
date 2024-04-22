package Practicas.pr4Excepciones;

public class DatosExcepcion extends RuntimeException{
    // Comprobada -> extends Exception
    // No comprobada -> RuntimeException
    public DatosExcepcion(){
        super();
    }
    public DatosExcepcion(String msg){
        super(msg);
    }
}
