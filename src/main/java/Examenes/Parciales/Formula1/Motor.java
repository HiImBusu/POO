package Examenes.Parciales.Formula1;

import java.util.Random;

public class Motor {
    private final String fabricante;
    private final double probRotura;
    private int potencia;

    public Motor(String fab, double probRot, int pot){
        fabricante = fab;
        probRotura = probRot;
        potencia = pot;
    }

    public String getFabricante(){
        return fabricante;
    }

    public int getPotencia(){
        return potencia;
    }

    public double getProbRotura(){
        return probRotura;
    }

    @Override
    public String toString() {
        return String.format("%s(%dCV)", fabricante, potencia);
    }

    public void desgaste(Random rnd){
        if(rnd.nextDouble() >= (1 - probRotura))
            potencia *= 0.9;
    }
}
