package Examenes._19JunioRegistroCivil.Solucion;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class RegistroCivil {
    private String estado;
    private SortedMap<Nombre, SortedMap<Integer, Integer>> registro;

    public RegistroCivil(String est, String fichero){
        if(est.isEmpty() || est.isBlank() || fichero.isEmpty() || fichero.isBlank())
            throw new RegistroCivilException("Error en el constructor: Estado/fichero vacios/nulos");
        this.estado = est;
        this.registro = new TreeMap<>();
        leerFichero(fichero);
    }
    public void leerFichero(String fichero){
        try(Scanner sc = new Scanner(Path.of(fichero))){
            while(sc.hasNextLine()){
                procesar(sc.nextLine());
            }
        } catch (IOException e) {
            throw new RegistroCivilException("Error en leer fichero: El fichero no se encuentra");
        }
    }
    private void procesar(String linea_fichero){
        Scanner sc = new Scanner(linea_fichero);
        String codigoEstado, nombre;
        char genero;
        int anio, n_repeticiones;

        // Establezco el separador entre los campos
        sc.useDelimiter("[;]");

        // Establezco el sistema decimal (en este caso no hace falta)
        // sc.useLocale(Locale.ENGLISH);

        // Extraigo los datos
        try{
            codigoEstado = sc.next();
            if(this.estado.equalsIgnoreCase(codigoEstado)){
                genero = sc.next().charAt(0);
                anio = sc.nextInt(); // anio = Integer.parseInt(sc.next());
                nombre = sc.next();
                n_repeticiones = sc.nextInt();
                agregar(new Nombre(genero, nombre), anio, n_repeticiones);
            }
        }catch (NoSuchElementException ex){
            throw new RegistroCivilException("Error en procesar: error de formato, el dato que se esperaba no se encuentra");
        }
    }
    public void agregar(Nombre n, int anio, int n_repeticiones){

        // Consulto si el nombre ya estaba en el diccionario
        SortedMap<Integer, Integer> dict_interno = registro.get(n);

        // Compruebo si estaba o no
        if(dict_interno == null){
            // Es la primera vez que encuentro este nombre, le creo el diccionario interno
            dict_interno = new TreeMap<>();
        }
        // Añado mi nuevo elemento
        dict_interno.put(anio, n_repeticiones);

        // Lo meto en el diccionario
        registro.put(n, dict_interno);
    }

    public String getEstado() {
        return estado;
    }
    public Set<Nombre> getNombres(){
        return registro.keySet();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        sj.add(this.estado);
        for(Nombre n : getNombres()){
            sj.add(String.format("%s:\t%s", n, registro.get(n)));
        }
        return sj.toString();
    }

    public SortedSet<String> selecciona(Filtro f){
        SortedSet<String> res = new TreeSet<>();
        for(Nombre n : registro.keySet()){
            if(f.criterio(n)){
                res.add(n.getNombre());
            }
        }
        return res;
    }
}
