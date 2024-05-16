package Examenes._22JunioProgramasTV;

import Examenes._22JunioProgramasTV.Solucion.ProgramacionTVException;

import java.util.Objects;

public class Hora implements Comparable<Hora>{
    private int hh;
    private int mm;
    public Hora(int h, int m){
        if(h < 0 || m < 0) throw new ProgramacionTVException("La hora o los minutos no pueden ser negativos");

        hh = (h + m/60) % 24;
        mm = m % 60;
    }

    public int getHora(){
        return hh;
    }
    public int getMinuto(){
        return mm;
    }
    public void incrementar(int minutos){
        hh = (hh + (minutos + mm) / 60) % 24;
        mm = (minutos + mm) % 60;
    }

    @Override
    public boolean equals(Object o) {
        boolean res = o instanceof Hora;
        Hora hora = res ? (Hora) o : null;
        return res && hh == hora.hh && mm == hora.mm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hh, mm);
    }

    @Override
    public int compareTo(Hora hora) {
        int res = Integer.compare(hh, hora.hh);
        if(res == 0)
            res = Integer.compare(mm, hora.mm);
        return res;
    }

    public int diferenciaMinutos(Hora hora){
        int minutos = hh * 60 + mm;
        int minutosHora = hora.hh * 60 + hora.mm;
        return Math.abs(minutos - minutosHora);
    }

    @Override
    public String toString() {
        String h = (hh < 10 ? "0" : "") + hh;
        String m = (mm < 10 ? "0" : "") + mm;
        return "[" + h + ":" + m + "]";
    }
}
