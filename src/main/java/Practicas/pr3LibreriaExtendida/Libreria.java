package Practicas.pr3LibreriaExtendida;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Libreria {
    // Atributos
    private ArrayList<Libro> libs;

    // Metodos
    // Constructor
    public Libreria(){
        // Lista inicialmente vacia
        libs = new ArrayList<>();
    }

    private int buscarLibro(String aut, String tit){
        // Devuelve el indice donde se encuentra el libro, si el libro no esta en la lista devuelve -1
        Libro l;
        int index = -1;
        for(int i = 0; i < libs.size(); i++){
            // libs[i] ANTIGUAMENTE
            l = libs.get(i);
            if(l.getAutor().equalsIgnoreCase(aut) && l.getTitulo().equalsIgnoreCase(tit)){
                index = i;
            }
        }
        return index;
    }
    protected void anyadirLibro(Libro l){
        // Si el libro 'l' esta en la lista, sustituir el libro que tienes por el nuevo libro
        // si no estaba en la lista, lo insertas al final de la lista
        int index = this.buscarLibro(l.getAutor(), l.getTitulo());
        if(index == -1){
            // Libro no existe
            libs.add(l);
            // libs[libs.n_libros] = l;
        }else{
            // Libro esta en la posicion 'index'
            libs.set(index, l);
            // libs[index] = l;
        }
    }
    public void addLibro(String aut, String tit, double pre){
        anyadirLibro(new Libro(aut, tit, pre));
    }

    public void remLibro(String aut, String tit){
        // 1. Buscar el libro
        int index = buscarLibro(aut, tit);
        if(index == -1)
            throw new RuntimeException(String.format("Libro no encontrado (%s, %s)", aut, tit));

        libs.remove(index);
    }
    public double getPrecioFinal(String aut, String tit){
        // 1. Buscar el libro
        int index = buscarLibro(aut, tit);
        if(index == -1)
            throw new RuntimeException(String.format("Libro no encontrado (%s, %s)", aut, tit));

        return libs.get(index).getPrecioFinal();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (Libro l : libs){
            sj.add(l.toString());
        }
        return sj.toString();
        // return libs.toString(); OTRA FORMA MAS FACIL
    }
}