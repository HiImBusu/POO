package Examenes._20JunioDados.Solucion;

import java.util.Random;

public class Dado {
    private static Random r = new Random();
    private int cara;
    public Dado(){
        agita();
    }
    public void agita(){
        this.cara = r.nextInt(1, 7);
    }

    public int getCara() {
        return cara;
    }

    @Override
    public String toString() {
        return String.format("[%d]", this.cara);
    }
}
