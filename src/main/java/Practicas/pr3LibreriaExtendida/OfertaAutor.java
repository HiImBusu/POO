package Practicas.pr3LibreriaExtendida;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OfertaAutor implements OfertaFlex{
    // Atributos
    private double porcDescuento;
    private String[] autoresOferta;

    // Metodos
    public OfertaAutor(double porc, String[] aut){
        porcDescuento = porc;
        // autoresOferta = aut; CUIDADO!!! ESTAIS COPIANDO LA REFERENCIA, SI DESDE FUERA TOCAN 'AUT' SE TOCARA VUESTRO ARRAY!
        autoresOferta = Arrays.copyOf(aut, aut.length); // DE ESTA FORMA, COPIO EXPLICITAMENTE EL ARRAY EN OTRO NUEVO ARRAY
    }

    private boolean estaAutorEnOferta(String autor){
        boolean ok = false;
        for (String aut : autoresOferta){
            if(aut.equalsIgnoreCase(autor)){
                ok = true;
            }
        }
        return ok;
    }

    @Override
    public double getDescuento(Libro lib) {
        double porc = 0.0;
        // Buscar el autor del libro 'lib' en mi lista de autoresOferta
        if(estaAutorEnOferta(lib.getAutor())){
            porc = porcDescuento;
        }
        return porc;
    }

    @Override
    public String toString() {
        // 20.0%[George Orwell, Isaac Asimov]
        return String.format("%.2f%% %s", porcDescuento, Arrays.toString(autoresOferta));
    }
}
