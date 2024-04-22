package Examenes._19JunioPatinetes.Solucion;

import Examenes._19JunioPatinetes.Empleado;

import java.util.Iterator;
import java.util.SortedSet;

public class EmpresaSeleccion extends Empresa{
    private Seleccion sel;
    public EmpresaSeleccion(String ne, String fichero, Seleccion seleccion) throws PatinetesException {
        super(ne, fichero);
        this.sel = seleccion;
    }

    @Override
    public void asignaPatinetesEmpleado(Empleado emp, SortedSet<Integer> codigos_patinetes) {
        // Filtramos la lista de codigos, solo con los patienetes que cumplan nuestro filtro
        Iterator<Integer> it = codigos_patinetes.iterator();
        Patinete p = null;
        while(it.hasNext()){
            p = buscaPatinete(it.next());
            if(p == null || !sel.seleccionar(p)){
                it.remove();
            }
        }
        super.asignaPatinetesEmpleado(emp, codigos_patinetes);
    }
}
