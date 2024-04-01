package Practicas.pr1Jarras;

public class Mesa {
    private Jarra jarra1, jarra2;

    public enum Posicion {Izquierda, Derecha}

    public Mesa(Jarra j1, Jarra j2){
        if(j1 == j2){
            throw new RuntimeException("No puede estar la misma jarra dos veces en la mesa");
        }
        jarra1 = j1;
        jarra2 = j2;
    }
    public Mesa (int c1, int c2){
       /* Jarra j1 = new Jarra(c1);
        Jarra j2 = new Jarra(c2);*/
        this(new Jarra(c1), new Jarra(c2));
    }

    public int capacidad (Posicion pos) {
        int t = 0; //Solución
        if (pos == Posicion.Izquierda) {
            t = jarra1.capacidad();
        } else {
            t = jarra2.capacidad();
        }
        return t;
    }

    public int contenido (Posicion pos){
        int t=0; //Solución
        if(pos == Posicion.Izquierda){
            t = jarra1.contenido();
        }else{
            t = jarra2.contenido();
        }
        return t;
    }

    public void llena (Posicion pos) {
        /*
        Otra opcion
            switch (p){
                case Derecha: jarra1.llena(); break;
                case Izquierda: jarra2.llena(); break;
            }
        */
        if (pos == Posicion.Izquierda) {
            jarra1.llena();
        } else {
            jarra2.llena();
        }
    }


    public void vacia (Posicion pos){
        if(pos == Posicion.Izquierda){
            jarra1.vacia();
        }else{
            jarra2.vacia();
        }
    }

    public void llenaDesde (Posicion pos){
        if(pos == Posicion.Izquierda){
            jarra2.llenaDesde(jarra1);
        }else{
            jarra1.llenaDesde(jarra2);
        }
    }

    @Override
    public String toString(){
        // no concateneis string's, hacerlo con Striog.Format...
        // return "M " + jarra1.toString() + ", " + jarra2.toString();
        return String.format("M (%s, %s)", jarra1.toString(), jarra2.toString());
    }
}
