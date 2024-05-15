package Examenes.Parciales.Formula1;

import java.util.*;

public class Circuito {
    // Atributos
    private String nombre;
    private double tiempoBase;
    private double factorDesgaste;
    private Random rnd;
    private ArrayList<Monoplaza> monoplazas;
    private int vueltasRestantes;

    public Circuito(String nom, double tB, double fD, int vueltas, Random rnd){
        if( nom.isEmpty() || nom.isBlank() ||
            tB <= 30 ||
            fD < 0.0 || fD > 1.0 ||
            rnd == null)
        {
            throw new RuntimeException();
        }
        nombre = nom;
        tiempoBase = tB;
        factorDesgaste = fD;
        this.rnd = rnd;
        monoplazas = new ArrayList<>();
        vueltasRestantes = vueltas;
    }
    public Circuito(String nom, double tB, double fD, int vueltas){
        this(nom, tB, fD, vueltas, new Random(100));
    }

    public String getNombre() {
        return nombre;
    }

    public double getTiempoBase() {
        return tiempoBase;
    }

    public double getFactorDesgaste() {
        return factorDesgaste;
    }

    public ArrayList<Monoplaza> getMonoplazas() {
        // return monoplazas;
        return new ArrayList<>(monoplazas);
    }

    public int getVueltasRestantes() {
        return vueltasRestantes;
    }
    private int buscarMonoplaza(Monoplaza m){
        int index = -1;
        for(int i = 0; i < monoplazas.size(); i++){
            if(monoplazas.get(i).getNumero() == m.getNumero()){
                index = i;
            }
        }
        return index;
    }
    public void addMonoplaza(Monoplaza m){
        if(m == null || buscarMonoplaza(m) != -1)
            throw new RuntimeException();

        monoplazas.add(m);
    }


    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        sj.add(nombre);
        sj.add(String.format("Vueltas restantes: %d", vueltasRestantes));
        sj.add("Situación carrera:");
        for (Monoplaza m : monoplazas){
            sj.add(String.format("\t%s",m.toString()));
        }
        return sj.toString();
    }

    public int simularVuelta(){
        if(vueltasRestantes == 0) throw new RuntimeException();

        // Para cada monoplaza del circuito modifica su tiempo total tras esa vuelta y calcula su desgaste.
        for(Monoplaza m : monoplazas){
            m.incVuelta(tiempoBase, factorDesgaste, rnd);
        }

        // Decrementa el contador de vueltas al circuito en uno
        vueltasRestantes--;

        // Haciendo uso del método estatico sort(List <T> l) de la
        // clase java.utils.Collections, reordenar la lista de los monoplazas
        // segun su tiempo de vuelta y a igualdad de tiempo, su
        // número de monoplaza
        java.util.Collections.sort(monoplazas);

        return vueltasRestantes;
    }

    public Monoplaza simularCarrera(){
        if(monoplazas.isEmpty()) throw new RuntimeException();

        while(vueltasRestantes > 0){
            // Simulo la vuelta
            simularVuelta();
            System.out.println(this.toString());
        }

        return monoplazas.get(0);
    }
}
