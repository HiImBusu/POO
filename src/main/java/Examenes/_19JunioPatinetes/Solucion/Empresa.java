package Examenes._19JunioPatinetes.Solucion;

import Examenes._19JunioPatinetes.Empleado;
import Examenes._19JunioPatinetes.Posicion;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Empresa {
    private String nombre;
    private SortedSet<Patinete> patinetes;
    private List<String> errores;
    private Map<Empleado, SortedSet<Integer>> empleados;

    public Empresa(String nom, String fichero) throws PatinetesException {
        this.nombre = nom;
        this.patinetes = new TreeSet<>();
        this.errores = new ArrayList<>();
        this.empleados = new HashMap<>();
        try(Scanner sc = new Scanner(Path.of(fichero))){
            while(sc.hasNextLine()){
                procesar(sc.nextLine());
            }
        }catch (IOException ex){
            throw new PatinetesException("Error al intentar abrir el fichero");
        }
    }

    private void procesar(String linea){
        try(Scanner sc = new Scanner(linea)){
            // Establezlo los delimitadores
            sc.useDelimiter("[;]");

            // Para usar los decimales con el punto
            sc.useLocale(Locale.ENGLISH);

            String ne = sc.next();
            if(ne.equalsIgnoreCase(this.nombre)){
                // Si el nombre de la empresa coincide
                patinetes.add(new Patinete(ne, sc.nextInt(), new Posicion(sc.nextDouble(), sc.nextDouble()), sc.nextDouble()));
            }
        }catch (InputMismatchException ex){
            errores.add(String.format("ERROR: Dato de tipo incorrecto LINEA: %s", linea));
        }catch (NoSuchElementException ex){
            errores.add(String.format("ERROR: Faltan datos LINEA: %s", linea));
        }catch (PatinetesException ex){
            errores.add(String.format("ERROR: %s LINEA: %s", ex.getMessage(), linea));
        }
    }

    public void asignaPatinetesEmpleado(Empleado emp, SortedSet<Integer> codigos_patinetes){
        SortedSet<Integer> codigos_finales = new TreeSet<>();

        for(int cod : codigos_patinetes){
            if(!patinete_ya_asignado(cod) && buscaPatinete(cod) != null){
                // Patinetes que no estan todavia en el diccionario (no han sido asignados a ningun empleado
                // Patienetes que ademas estan en la lista de patinetes
                codigos_finales.add(cod);
            }
        }

        if(empleados.containsKey(emp)){
            // Si el empleado ya estaba le añado ademas los que ya tenia asignados
            codigos_finales.addAll(empleados.get(emp));
        }
        empleados.put(emp, codigos_finales);
    }

    private boolean patinete_ya_asignado(int cod){
        SortedSet<Integer> pat_asignados = new TreeSet<>();
        for(Map.Entry<Empleado, SortedSet<Integer>> ent : empleados.entrySet()){
            pat_asignados.addAll(ent.getValue());
        }
        return pat_asignados.contains(cod);
    }

    public Patinete buscaPatinete(int cod){
        Patinete pat = null;
        for(Patinete p : patinetes){
            if(p.getCodigo() == cod){
                pat = p;
            }
        }
        return pat;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        sj.add(this.nombre);
        sj.add(String.format("Patinetes: %s", patinetes));
        sj.add(String.format("Errores: %s", errores));
        sj.add(String.format("Empleados: %s", empleados));
        return sj.toString();
    }

    public void modificaPatinete(int cod, Posicion pos, double auto) throws PatinetesException {
        Patinete pat = buscaPatinete(cod);
        if(pat == null)
            throw new PatinetesException("Error: El patinete no se encuentra en la lista de patinetes");

        pat.setPosicion(pos);
        pat.setAutonomia(auto);
    }
}
