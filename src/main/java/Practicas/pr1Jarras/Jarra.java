package Practicas.pr1Jarras;

public class Jarra {

    private final int capacidad;
    private int contenido;

    public Jarra (int capInicial){
        if(capInicial<=0) throw new RuntimeException("No se puede crear una jarra con capacidad negativa");
        capacidad = capInicial;
        contenido = 0;
    }

    public int capacidad(){return capacidad;}

    public int contenido(){return contenido;}

    public void llena(){contenido = capacidad;}

    public void vacia(){this.contenido=0;}

    public void llenaDesde(Jarra otra){
        if(otra == this){
            throw new RuntimeException("No se puede volcar una misma jarra");
        }
        /*
        1. Quitar litro a listro (codido algo ineficiente, se puede hacer el traspaso de un tiron
        while((this.contenido<this.capacidad)&&(otra.contenido>0)){
            ++this.contenido;
            --otra.contenido;
        }
        */
        int agua = Math.min(capacidad - contenido, otra.contenido);
        this.contenido += agua;
        otra.contenido -= agua;
    }

    @Override
    public String toString(){
        // No concatenamos! Formateamos cadenas
        // return "J" + "(" + this.capacidad + ", " + this.contenido + ")";
        return String.format("J(%d, %d)", capacidad, contenido);
    }
}

