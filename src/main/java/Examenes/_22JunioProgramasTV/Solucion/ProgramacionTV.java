package Examenes._22JunioProgramasTV.Solucion;

import Examenes._22JunioProgramasTV.Hora;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class ProgramacionTV {
    protected Map<String, SortedSet<ProgramaTV>> cadenas;

    public ProgramacionTV(){
        cadenas = new HashMap<>();
    }

    public void agregar(String cadenaTV, ProgramaTV prog){
        SortedSet<ProgramaTV> programas = cadenas.getOrDefault(cadenaTV, new TreeSet<>());
        programas.add(prog);
        cadenas.put(cadenaTV, programas);
    }

    public void leerProgramas(String fichero){
        try(Scanner sc = new Scanner(Path.of(fichero))){
            while(sc.hasNextLine()){
                procesar(sc.nextLine());
            }
        }catch (IOException ex){
            throw new ProgramacionTVException("El fichero no se encuentra");
        }
    }
    public void procesar(String linea){
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter("[>@:-]+");
            agregar(sc.next(), new ProgramaTV(sc.next(), new Hora(sc.nextInt(), sc.nextInt()), sc.nextInt()));
        }catch (Exception ex){
            System.out.println("Error al procesar la linea: " + linea);
        }
    }

    public void mostrarProgramas(String fichero){
        try(PrintWriter pw = new PrintWriter(fichero)){
            mostrarProgramas(pw);
        } catch (FileNotFoundException e) {
            throw new ProgramacionTVException("No se pudo crear el fichero");
        }
    }
    public void mostrarProgramas(PrintWriter pw){
        for(Map.Entry<String, SortedSet<ProgramaTV>> entru : cadenas.entrySet()){
            pw.println(entru.getKey() + ":");
            for(ProgramaTV prog : entru.getValue()){
                pw.println("\t" + prog);
            }
        }
    }

    public boolean esConsistente(String cadenaTV){
        if(!cadenas.containsKey(cadenaTV))
            throw new ProgramacionTVException("La cadena no se encuentra");

        boolean cumple = true;
        if(cadenas.size() > 1){
            SortedSet<ProgramaTV> programas = cadenas.get(cadenaTV);
            Iterator<ProgramaTV> it = programas.iterator();
            ProgramaTV pant, pactual;
            pant = it.next(); // me coloco en el primero
            while(it.hasNext()){
                pactual = it.next(); // me coloco en el siguiente
                if(pant.getHoraFin().compareTo(pactual.getHoraInicio()) > 0){
                    cumple = false;
                }
                pant = pactual;
            }
        }
        return cumple;
    }

    public SortedSet<ProgramaTV> sugerencias(SugerenciasTV seleccion){
        SortedSet<ProgramaTV> filtro = new TreeSet<>(new OrdenAlternativoProgramaTV());
        for(SortedSet<ProgramaTV> progs : cadenas.values()){
            filtro.addAll(seleccion.sugerencias(progs));
        }
        return filtro;
    }

}
