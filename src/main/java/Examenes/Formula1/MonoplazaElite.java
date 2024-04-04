package Examenes.Formula1;

import java.util.Random;

public class MonoplazaElite extends Monoplaza{
    public MonoplazaElite(int num, String nomPil, String nomEscu, TipoRueda tipoRueda, Motor m){
        super(num, nomPil, nomEscu, tipoRueda, m);
    }

    @Override
    public void incVuelta(double tiempoBaseCircuito, double factorDesgasteCircuito, Random rnd) {
        super.incVuelta(tiempoBaseCircuito, factorDesgasteCircuito, rnd);

        // Reduce aun mas su tiempo de vuelta
        double tiempoExtra = rnd.nextDouble();
        tiempoTotal -= tiempoExtra;
        tiempoActual -= tiempoExtra;
    }

    @Override
    public String toString() {
        return String.format("%s *", super.toString());
    }
}
