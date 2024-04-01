package Practicas.pr3LibreriaExtendida;

import java.util.Arrays;

public class LibreriaOferta extends Libreria{
    // Atributos
    private double porcDescuento;
    private String[] autoresOferta;


    // Metodos
    public LibreriaOferta(double porc, String[] aut){
        // Invoco al constructor de mi padre para construir el arrayList
        super();
        setOferta(porc, aut);
    }

    public void setOferta(double porc, String[] aut){
        this.porcDescuento = porc;
        // this.autoresOferta = aut;
        // COPIAR el array explicitamente, no mantener una referencia a el que puede llevar a errores!!!!
        this.autoresOferta = Arrays.copyOf(aut, aut.length);
    }

    public String[] getOferta(){
        // Le devuelvo un array con la copia de mi array interno de autores en oferta
        return Arrays.copyOf(autoresOferta, autoresOferta.length);
    }

    public double getDescuento(){
        return porcDescuento;
    }

    // FUNCIONES AUXILIARES SIEMPRE PRIVATE
    // Si quiero que mis hijos tambien puedan usarla, protected
    // pero en NIGUN CASO public
    private boolean existeAutorOferta(String autor){
        boolean ok = false;
        for(String aut : autoresOferta){
            if(aut.equalsIgnoreCase(autor)){
                ok = true;
            }
        }
        return ok;
    }

    @Override
    public void addLibro(String aut, String tit, double pre) {
        // Comprobar si "aut" esta en la lista de "autoresOferta"
        Libro lib = null;
        if(existeAutorOferta(aut)){
            // Creo la instancia como un "LibroOferta"
            lib = new LibroOferta(aut, tit, pre, porcDescuento);
        }else{
            // Creo la instancia como un "Libro"
            lib = new Libro(aut, tit, pre);
        }
        anyadirLibro(lib);
    }



}
