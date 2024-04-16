package Conceptos.Excepciones;

public class MiExcepcionNoComprobada extends RuntimeException{
    public MiExcepcionNoComprobada(){
        super();
    }
    public MiExcepcionNoComprobada(String msg){
        super(msg);
    }
}
