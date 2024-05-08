package Examenes._20SepPruebas.Solucion;

import java.util.Iterator;
import java.util.Set;

public class SelectorUmbralExito implements Selector{
    private int porcMinimo;
    public SelectorUmbralExito(int porc){
        if(porc < 0)
            throw new AppException();

        this.porcMinimo = porc;
    }

    public int getPorcMinimo() {
        return porcMinimo;
    }

    @Override
    public boolean esSeleccionable(Set<Practica> set) {
        int sumaExito = 0;
        int sumaRealizadas = 0;
        Iterator<Practica> it = set.iterator();
        Practica pra = null;
        while(it.hasNext()){
            pra = it.next();
            sumaExito += pra.getCntExito();
            sumaRealizadas += pra.getCntRealizadas();
        }
        return porcMinimo <= (100 * sumaExito)/sumaRealizadas;
    }
}