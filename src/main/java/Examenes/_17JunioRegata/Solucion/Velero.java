package Examenes._17JunioRegata.Solucion;

import Examenes._17JunioRegata.Posicion;

public class Velero extends Barco{
    private static int UMBRAL_MENOR = 45;
    private static int UMBRAL_MAYOR = 315;
    private static int VARIACION_VELOCIDAD = -3;

    public Velero(String nom, Posicion pos, int rum, int vel){
        super(nom, pos, rum, vel);
    }

    @Override
    public void avanza(int mnt) {
        if(this.rumbo <= UMBRAL_MENOR || this.rumbo >= UMBRAL_MAYOR)
            super.avanza(mnt + VARIACION_VELOCIDAD);
        else
            super.avanza(mnt);
    }
}
