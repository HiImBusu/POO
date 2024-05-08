package Examenes._20SepPruebas.Solucion;

import java.util.*;

public class SelectorNombre implements Selector{
    private SortedSet<String> nombres;

    public SelectorNombre(Set<String> nom){
        if(nom == null)
            throw new AppException();

        this.nombres = new TreeSet<>();
        for(String n : nom){
            this.nombres.add(n.toUpperCase());
        }
    }

    public SortedSet<String> getNombres() {
        return nombres;
    }

    @Override
    public boolean esSeleccionable(Set<Practica> set) {
        boolean ok = false;
        Iterator<Practica> it;
        Practica pra = null;
        if(!set.isEmpty()){
            ok = true;
            it = set.iterator();
            while(it.hasNext()){
                pra = it.next();
                if(!nombres.contains(pra.getNombre().toUpperCase())){
                    ok = false;
                }
            }
        }
        return ok;
    }
}
