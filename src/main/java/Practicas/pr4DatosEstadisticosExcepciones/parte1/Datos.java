package Practicas.pr4DatosEstadisticosExcepciones.parte1;

import java.util.ArrayList;
import java.util.List;

public class Datos {
    // Atributos
    private List<Double> datos;
    private List<String> errores;
    private double min;
    private double max;

    // Metodos
    public Datos(String[] d, double minimo, double maximo){
        double dato_parseado;

        // Instanciamos las listas
        datos = new ArrayList<>();
        errores = new ArrayList<>();

        // Las rellenamos
        for(String dat : d){
            try{
                dato_parseado = Double.parseDouble(dat);
                datos.add(dato_parseado);
            }catch (NumberFormatException ex){
                errores.add(dat);
            }
        }

        // A parte establecemos el minimo y el maximo
        this.min = minimo;
        this.max = maximo;
    }

    private boolean valor_en_rango(Double dato){
        return dato >= min && dato <= max;
    }

    public double calcMedia(){
        double sumatorio = 0.0;
        int n_elementos = 0;
        for(Double dat : datos){
            if(valor_en_rango(dat)){
                sumatorio += dat.doubleValue();
                n_elementos++;
            }
        }

        // Si no hay numeros en el rango, lanzo la excepcion
        if(n_elementos == 0)
            throw new DatosException("No hay datos en el rango especificado");

        // Sino, devuelvo el valor calculado
        return sumatorio/n_elementos;
    }

    public double calcDesvTipica(){
        double media = calcMedia();
        double sumatorio = 0.0;
        int n_elementos = 0;
        for(Double dat : datos){
            if(valor_en_rango(dat)){
                sumatorio += Math.pow(dat.doubleValue() - media, 2);
                n_elementos++;
            }
        }
        return Math.sqrt(sumatorio/n_elementos);
    }


    public void setRango(String rango){
        try{
            int index = rango.indexOf(";");
            if(index != -1){
                min = Double.parseDouble(rango.substring(0, index));
                max = Double.parseDouble(rango.substring(index + 1, rango.length()));
            }else{
                throw new DatosException("Error en los datos al establecer el rango");
            }
        }catch (Exception e){
            throw new DatosException("Error en los datos al establecer el rango");
        }
    }

    public List<Double> getDatos() {
        return datos;
    }

    public List<String> getErrores() {
        return errores;
    }

    @Override
    public String toString() {
        String media, desvTi;
        try{
            media = Double.valueOf(calcMedia()).toString();
        }catch (Exception e) { media = "ERROR"; }
        try{
            desvTi = Double.valueOf(calcDesvTipica()).toString();
        }catch (Exception e) { desvTi = "ERROR"; }

        return String.format("Min: %.1f, Max: %.1f,\n %s,\n %s,\n Media: %s, DesvTipica: %s",
                min, max, datos, errores, media, desvTi);
    }
}
