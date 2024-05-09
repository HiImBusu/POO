package Examenes._17SepRedSocial.Solucion;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Cuenta {
    private String usuario;
    private SortedSet<Mensaje> mensajes;

    public Cuenta(String usr){
        if(usr.isEmpty() || usr.isBlank())
            throw new AppException("Usuario no valido");

        this.usuario = usr;
        this.mensajes = new TreeSet<>();
    }

    public String getUsuario() {
        return usuario;
    }
    public void addMsj(String receptor, String txt){
        this.mensajes.add(new Mensaje(this.usuario, receptor, txt));
    }
    public SortedSet<Mensaje> getMsjs(Filtro flt){
        SortedSet<Mensaje> conj = new TreeSet<>();

        Iterator<Mensaje> it = this.mensajes.iterator();
        Mensaje msj = null;
        while(it.hasNext()){
            msj = it.next();
            if(flt == null)
                conj.add(msj);
            else
                if(flt.select(msj))
                    conj.add(msj);
        }
        return conj;
    }

    @Override
    public String toString() {
        return this.mensajes.toString();
    }
}
