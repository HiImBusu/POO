package Examenes._20SepPruebas.Solucion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class Resultados {
    private SortedSet<Practica> practicas;
    private SortedMap<String, SortedSet<Practica>> alumnos;

    public Resultados(Set<Practica> prac){
        alumnos = new TreeMap<>();
        practicas = new TreeSet<>(prac);
    }

    private Practica buscar(SortedSet<Practica> practicas, String desc){
        Practica pra = null;
        Iterator<Practica> it = practicas.iterator();
        Practica p = null;
        while(it.hasNext() && pra == null){
            p = it.next();
            if(desc.equalsIgnoreCase(p.getDescripcion()))
                pra = p;
        }
        return pra;
    }

    public void anyadirPractica(Practica pr){
        Practica practica = buscar(practicas, pr.getDescripcion());
        if(practica == null)
            throw new AppException("Error: Descripcion erronea " + pr.getDescripcion());

        pr.setCntRealizadas(practica.getCntRealizadas());

        // Dame el conjunto que tengo para ese alumno o creame uno nuevo
        SortedSet<Practica> set = alumnos.getOrDefault(pr.getNombre(), new TreeSet<>());
        if(set.contains(pr)){
            // Si ya estaba lo machaco
            set.remove(pr);
            set.add(pr);
        }else{
            // Si no estaba lo meto
            set.add(pr);
        }
        // Meto el conjunto generado en el diccionario
        alumnos.put(pr.getNombre(), set);
    }

    public Resultados seleccionar(Selector selector){
        Resultados r = new Resultados(this.practicas);
        for(SortedSet<Practica> pr : this.alumnos.values()){
            if(selector.esSeleccionable(pr)){
                for(Practica prac : pr){
                    r.anyadirPractica(prac);
                }
            }
        }
        return r;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("; ", "[", "]");
        for(SortedSet<Practica> pr : this.alumnos.values()){
            for(Practica p : pr){
                sj.add(p.toString());
            }
        }
        return String.format("{%s, %s}", this.practicas, sj.toString());
    }

    public void guardarEnFichero(String fic) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(fic)){
            for(Set<Practica> prac : this.alumnos.values()){
                for(Practica pr : prac){
                    pw.printf("%s; %s; %d\n", pr.getNombre(), pr.getDescripcion(), pr.getCntExito());
                }
            }
        }
    }

    public void cargarDeFichero(String fic) throws IOException {
        try(Scanner sc = new Scanner(Path.of(fic))){
            while (sc.hasNextLine()){
                procesarLinea(sc.nextLine());
            }
        }
    }
    private void procesarLinea(String linea){
        String nom, desc;
        int exito;
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter("\\s*[;]\\s*");

            nom = sc.next();
            desc = sc.next();
            exito = sc.nextInt();

            anyadirPractica(new Practica(nom, desc, 0, exito));
        }
    }

    public void completarPracticas(){
        SortedSet<Practica> practicas_faltan = new TreeSet<>();

        Practica p = null;
        for(Practica pr : this.practicas){
            for(Map.Entry<String, SortedSet<Practica>> entry : this.alumnos.entrySet()){
                p = buscar(entry.getValue(), pr.getDescripcion());
                if(p == null){
                    practicas_faltan.add(new Practica(entry.getKey(), pr.getDescripcion()));
                }
            }
        }




/*
        for(String nom_alumno : this.alumnos.keySet()){
            for(Practica pr : this.practicas){
                if(!alumnos.get(nom_alumno).contains(pr)){
                    // Voy apuntando todas las practicas que le faltan a cada alumno
                    practicas_faltan.add(new Practica(nom_alumno, pr.getDescripcion()));
                }
            }
        }

 */
        // Una vez ya tengo todas las practicas que faltan, las meto todas
        for(Practica pr : practicas_faltan){
            anyadirPractica(pr);
        }
    }
}
