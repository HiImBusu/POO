package Examenes._17SepRedSocial.Solucion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class FiltroTexto implements Filtro{
    private Set<String> claves;

    public FiltroTexto(Set<String> c){
        this.claves = new HashSet<>();

        Iterator<String> it = c.iterator();
        while(it.hasNext()){
            this.claves.add(it.next().toUpperCase());
        }
    }

    @Override
    public boolean select(Mensaje m) {
        boolean ok = false;
        Iterator<String> it = this.claves.iterator();
        String key = "";
        while(it.hasNext() && !ok){
            key = it.next();
            if(m.getTexto().toUpperCase().contains(key))
                ok = true;
        }
        return ok;
    }
}
