package Examenes.Formula1;

import java.util.Random;

public class Monoplaza implements Comparable<Monoplaza>{
    private static final int VENTAJA_C1 = 1;
    private static final int VENTAJA_C2 = 2;
    private static final int VENTAJA_C3 = 3;
    private static final int VENTAJA_C4 = 4;
    private static final int VENTAJA_C5 = 5;

    private int numero;
    private String nombrePiloto;
    private String nombreEscuderia;
    private Rueda DD, DI, TD, TI;
    private Motor motor;
    protected double tiempoTotal;
    protected double tiempoActual;
    private double tiempoAnterior;

    public Monoplaza(int num, String nomPil, String nomEscu, TipoRueda tipoRueda, Motor mot){
        if(num <= 0 ||
                nomPil.isEmpty() || nomPil.isBlank() ||
                nomEscu.isEmpty() || nomEscu.isBlank() ||
                tipoRueda == null ||
                mot == null
        ){
            throw new RuntimeException();
        }
        numero = num;
        nombrePiloto = nomPil;
        nombreEscuderia = nomEscu;
        DD = new Rueda(tipoRueda);
        DI = new Rueda(tipoRueda);
        TD = new Rueda(tipoRueda);
        TI = new Rueda(tipoRueda);
        motor = mot;
        tiempoTotal = 0.0;
        tiempoActual = 0.0;
        tiempoAnterior = 0.0;
    }

    public String getNombrePiloto() {
        return nombrePiloto;
    }

    public String getNombreEscuderia() {
        return nombreEscuderia;
    }

    public int getNumero() {
        return numero;
    }

    public Rueda getDD() {
        return DD;
    }

    public Rueda getDI() {
        return DI;
    }

    public Rueda getTD() {
        return TD;
    }

    public Rueda getTI() {
        return TI;
    }

    public Motor getMotor() {
        return motor;
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }

    private double getTiempoActual() {
        return tiempoActual;
    }
    private String doubleToTime(double time){
        return String.format("[%d:%d:%d]", (int) (Math.abs(time) / 60), (int) (Math.abs(time) % 60), (int) ((Math.abs(time) * 1_000_000) % 1_000_000));
    }
    private String getDiffTiempoAnteriorActual(){
        double diff = 0.0;
        if(tiempoAnterior != 0.0){
            diff = tiempoActual - tiempoAnterior;
        }

        String sign = "";
        if(diff > 0.0) sign = "+";
        else if(diff < 0.0) sign = "-";

        return String.format("%s%s", sign, doubleToTime(diff));
    }

    @Override
    public int compareTo(Monoplaza o) {
        int compare = Double.compare(tiempoTotal, o.tiempoTotal);
        if(compare == 0) compare = Integer.compare(numero, o.numero);
        return compare;
    }

    public TipoRueda getTipoRueda(){
        return DD.getTipoRueda();
    }

    public double getDesgasteMedio(){
        return (DD.getDesgaste() + DI.getDesgaste() + TI.getDesgaste() + TD.getDesgaste())/4.0;
    }

    @Override
    public String toString() {
        return String.format("%d : %s (%s/%s) %s(%.2f%%) Last: %s Diff: %s Total: %s",
                numero,
                nombrePiloto,
                nombreEscuderia,
                motor,
                getTipoRueda(),
                getDesgasteMedio() * 100,
                doubleToTime(tiempoActual),
                getDiffTiempoAnteriorActual(),
                doubleToTime(tiempoTotal));
    }

    private int getVentajaNeumatico(){
        int ventaja = 0;
        switch (getTipoRueda()){
            case C1 -> ventaja = VENTAJA_C1;
            case C2 -> ventaja = VENTAJA_C2;
            case C3 -> ventaja = VENTAJA_C3;
            case C4 -> ventaja = VENTAJA_C4;
            case C5 -> ventaja = VENTAJA_C5;
        }
        return ventaja;
    }
    public void incVuelta(double tiempoBaseCircuito, double factorDesgasteCircuito, Random rnd){
        tiempoAnterior = tiempoActual;
        tiempoActual = tiempoBaseCircuito +
                (5 * (1 - getDesgasteMedio())) +
                getVentajaNeumatico() +
                (5 * ((double) (700 - motor.getPotencia()) / 700)) +
                (1 * rnd.nextDouble());
        tiempoTotal = tiempoTotal + tiempoActual;
        // Aplicamos desgaste
        motor.desgaste(rnd);
        DD.desgaste(factorDesgasteCircuito, rnd);
        DI.desgaste(factorDesgasteCircuito, rnd);
        TD.desgaste(factorDesgasteCircuito, rnd);
        TI.desgaste(factorDesgasteCircuito, rnd);
    }
}
