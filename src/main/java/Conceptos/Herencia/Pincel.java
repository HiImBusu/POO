package Conceptos.Herencia;

import java.util.StringJoiner;

public class Pincel extends Punto{
    // Atributos
    // private Punto p; COMPOSICION
    private double grosor;

    public Pincel(){
        // super();
        // grosor = 0;

        this(0, 0, 0);
    }
    public Pincel(double x, double y){
        // super(x, y);

        this(x, y, 0);
    }

    public Pincel(double x, double y, double gro){
        // this.setX(x);
        // this.setY(y);
        super(x, y); // Invoco al constructor con dos parametros de MI PADRE

        // Extender
        this.grosor = gro;
    }

    public double getGrosor(){
        return this.grosor;
    }

    public void setGrosor(double gr){
        this.grosor = gr;
    }

    @Override
    public void trasladar(double incX, double incY) {
        // Muevo el punto como mi padre
        super.trasladar(incX, incY);

        // Extiendo mi comportamiento
        // this.grosor = this.grosor * 0.99;
        setGrosor(grosor * 0.99);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "(", ")");
        sj.add(Double.toString(super.getX()));
        sj.add(Double.toString(super.getY()));
        sj.add(Double.toString(this.grosor));
        return sj.toString();
    }
}
