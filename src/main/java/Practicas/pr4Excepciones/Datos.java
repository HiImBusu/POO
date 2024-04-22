package Practicas.pr4Excepciones;

import java.util.ArrayList;
import java.util.List;

public class Datos {
    // Atributos
    private List<Double> datos;
    private List<String> errores;
    private double min, max;

    public Datos(String[] dat, double minimo, double maximo){
        // dat = {"3.14", "3", "Marco"};
        double numero;
        // Creo ambas listas
        datos = new ArrayList<>();
        errores = new ArrayList<>();

        // Voy insertando los numeros
        for(String d : dat){
            try{
                numero = Double.parseDouble(d);
                datos.add(numero);
            }catch (NumberFormatException e){
                errores.add(d);
            }
        }
        this.min = minimo;
        this.max = maximo;
    }

    private boolean esta_en_rango(double d){
        return d >= min && d <= max;
    }
    public double calcMedia(){
        double sumador = 0.0;
        int contador = 0;
        // Recorrer la lista de 'datos'
        for(Double d : datos){
            // Comprobar si esta en el rango
            if(esta_en_rango(d)){
                sumador += d;
                contador++;
            }
        }
        if(contador == 0)
            throw new DatosExcepcion("No hay datos en el rango especificado");

        return sumador/contador;
    }

    public double caclDesvTipica(){
        double media = calcMedia();
        double sumatorio = 0;
        int contador = 0;

        for(Double d : datos){
            if(esta_en_rango(d)){
                sumatorio += Math.pow(d - media, 2);
                contador++;
            }
        }
        return Math.sqrt(sumatorio/contador);
    }

    public void setRango(String r){
        // "1;2" ===> min = 1; max = 2
        // "Marco;Ana"
        try{
            int index = r.indexOf(";");
            min = Double.parseDouble(r.substring(0, index));
            max = Double.parseDouble(r.substring(index + 1));
        }catch (Exception ex){
            // Revienta "substring"
            throw  new DatosExcepcion("Error en los datos al establecer el rango");
        }
    }

    public List<Double> getDatos(){
        return datos;
    }

    public List<String> getErrores() {
        return errores;
    }

    @Override
    public String toString() {
        String med;
        String dt;
        try{
            med = Double.toString(calcMedia());
            dt = Double.toString(caclDesvTipica());
        }catch (DatosExcepcion ex){
            med = "ERROR";
            dt = "ERROR";
        }
        return String.format("Min: %.1f, Max: %.1f,\n" +
                "%s,\n%s\nMedia: %s, DesvTipica: %s", min, max, datos.toString(), errores.toString(), med, dt);
    }
}
