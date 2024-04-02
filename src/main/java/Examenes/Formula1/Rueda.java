package Examenes.Formula1;

import java.util.Random;

public class Rueda {
    private static final double FD_C1 = 0.9;
    private static final double FD_C2 = 0.92;
    private static final double FD_C3 = 0.94;
    private static final double FD_C4 = 0.96;
    private static final double FD_C5 = 0.97;
    private final TipoRueda tipoRueda;
    private double desgaste;

    public Rueda(TipoRueda ti){
        if(ti == null) throw new RuntimeException();
        tipoRueda = ti;
        desgaste = 1.0;
    }
    public TipoRueda getTipoRueda(){
        return tipoRueda;
    }
    public double getDesgaste(){
        return desgaste;
    }

    @Override
    public String toString() {
        return String.format("%s(%5.2f%%)", tipoRueda, desgaste);
    }

    private double getFactorDesgasteRueda(){
        double fact = 1.0;
        switch (tipoRueda){
            case C1 -> fact = FD_C1;
            case C2 -> fact = FD_C2;
            case C3 -> fact = FD_C3;
            case C4 -> fact = FD_C4;
            case C5 -> fact = FD_C5;
        }
        return fact;
    }
    public void desgaste(double factorDesgasteCircuito, Random rnd){
        desgaste = desgaste *
                factorDesgasteCircuito *
                getFactorDesgasteRueda() *
                (0.99 + (0.1 * rnd.nextDouble()));
    }
}