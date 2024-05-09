package Examenes._17SepRedSocial.Solucion;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
public class CuentaModerada extends Cuenta{
    private Set<String> malsonantes;

    public CuentaModerada(String usr, Set<String> c){
        super(usr);
        if(c == null || c.isEmpty())
            throw new AppException("Conjunto de palabras malsonantes vacio");
        this.malsonantes = c;
    }

    @Override
    public void addMsj(String receptor, String txt) {
        Iterator<String> it = this.malsonantes.iterator();
        String mal;
        boolean contiene_alguna = false;
        while(it.hasNext()){
            mal = it.next();
            if(txt.contains(mal)){
                contiene_alguna = true;
            }
        }
        if(!contiene_alguna)
            super.addMsj(receptor, txt);
    }
}
