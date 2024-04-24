package Examenes._21JunioCovid.Solucion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class MapaCOVID {
    private String nombre;
    private SortedMap<String, SortedSet<DistritoSanitario>> mapa;

    public MapaCOVID(String nombre, String fichero){
        this.nombre = nombre;
        this.mapa = new TreeMap<>();
        leerDatos(fichero);
    }
    private void leerDatos(String fichero){
        try(Scanner sc = new Scanner(Path.of(fichero))){
            while(sc.hasNextLine()){
                procesar(sc.nextLine());
            }

        }catch (IOException ex){
            throw new COVIDException("No se ha podido encontrar el fichero");
        }
    }
    private void procesar(String linea){
        String distrito, prov;
        int pob, casos;
        try(Scanner sc = new Scanner(linea)){
            // Establezco los delimitadores
            sc.useDelimiter("[():]+");

            distrito = sc.next();
            prov = sc.next();
            pob = sc.nextInt();
            casos = sc.nextInt();

            agregarDistrito(prov, new DistritoSanitario(distrito, pob, casos));
        }
        catch (Exception ex){
            // No hacemos nada, pasamos de esa linea
            System.err.println("No se ha podido procesar la linea: " + linea + " motivo: " + ex.getMessage());
        }
    }
    public void agregarDistrito(String prov, DistritoSanitario ds){
        SortedSet<DistritoSanitario> distritos = this.mapa.get(prov);
        if(distritos == null)
            distritos = new TreeSet<>();

        // Insertamos el distrito, si ya estaba no hara nada al estar definido como un Set
        distritos.add(ds);

        // lo meto en el diccionario
        this.mapa.put(prov, distritos);
    }

    public String getNombre() {
        return nombre;
    }
    public Set<String> getProvincias(){
        return this.mapa.keySet();
    }
    public Set<DistritoSanitario> getDistritos(){
        SortedSet<DistritoSanitario> todos_distritos = new TreeSet<>();
        for(SortedSet<DistritoSanitario> ds : this.mapa.values()){
            todos_distritos.addAll(ds);
        }
        return todos_distritos;
    }
    public int incidenciaProvincia(String prov){
        SortedSet<DistritoSanitario> dist = this.mapa.get(prov);
        int incidencia = 0;
        for(DistritoSanitario d : dist){
            incidencia += d.incidenciaAcumulada();
        }
        return incidencia;
    }

    public void mostrarMapa(String nomFich) throws FileNotFoundException {
        mostrarMapa(new PrintWriter(nomFich));
    }
    public void mostrarMapa(PrintWriter pw){
        pw.printf("%s: \n", nombre.toUpperCase());
        for(Map.Entry<String, SortedSet<DistritoSanitario>> entry : this.mapa.entrySet()){
            pw.printf("%s\n", entry.getKey());
            for(DistritoSanitario ds : entry.getValue()){
                pw.printf("\t%s\n", ds);
            }
        }
        pw.close();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: \n", nombre.toUpperCase()));
        for(Map.Entry<String, SortedSet<DistritoSanitario>> entry : this.mapa.entrySet()){
            sb.append(String.format("%s\n", entry.getKey()));
            for(DistritoSanitario ds : entry.getValue()){
                sb.append(String.format("\t%s\n", ds));
            }
        }
        return sb.toString();
    }

    public Set<String> obtenerInfoCOVID(InfoCOVID info){
        return info.obtenerInfo(this);
    }
}
