package Examenes._17JunioRegata.Solucion;
import Examenes._17JunioRegata.Posicion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class Regata {
    private SortedSet<Barco> participantes;
    public Regata(){
        participantes = new TreeSet<>();
    }

    public void agrega(Barco b){
        this.participantes.add(b);
    }

    public void avanza(int mnt){
        Iterator<Barco> it = this.participantes.iterator();
        while(it.hasNext()){
            it.next().avanza(mnt);
        }
    }

    public Set<Barco> getParticipantes() {
        return this.participantes;
    }
    public Set<Barco> ordenadosPorDistancia(){
        SortedSet<Barco> ord = new TreeSet<>(new SatBarco());
        Iterator<Barco> it = this.participantes.iterator();
        while(it.hasNext()){
            ord.add(it.next());
        }
        return ord;
    }

    public boolean velocidadSuperiorA(int velocidad){
        boolean ok = false;
        Iterator<Barco> it = this.participantes.iterator();
        Barco b = null;
        while(it.hasNext() && !ok){
            b = it.next();
            if(b.velocidad >= velocidad)
                ok = true;
        }
        return ok;
    }

    public List<Barco> dentroDelCirculo(Posicion p, int km){
        List<Barco> lista = new ArrayList<>();
        Iterator<Barco> it = this.participantes.iterator();
        Barco b = null;
        while(it.hasNext()){
            b = it.next();
            if(b.posicion.distancia(p) < km)
                lista.add(b);

        }
        return lista;
    }

    public Map<Integer, Set<Barco>> barcosPorVelocidad(){
        Map<Integer, Set<Barco>> dict = new HashMap<>();
        Set<Barco> conj = null;

        Iterator<Barco> it = this.participantes.iterator();
        Barco b = null;
        int cota = 0;
        while(it.hasNext()){
            b = it.next();
            cota = b.velocidad/10;

            conj = dict.getOrDefault(cota, new HashSet<>());
            conj.add(b);
            dict.put(cota, conj);
        }
        return dict;
    }

    public Barco creaBarcoString(String linea){
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter("[ ,]+");
            sc.useLocale(Locale.UK); // Para los decimales
            return new Barco(sc.next(), new Posicion(sc.nextDouble(), sc.nextDouble()), sc.nextInt(), sc.nextInt());
        }catch (Exception e){
            throw new RegataException(e.getMessage());
        }
    }
    public void leeFichero(String fic) throws FileNotFoundException {
        try(Scanner sc = new Scanner(Path.of(fic))){
            lee(sc);
        }catch (IOException ex){
            throw new FileNotFoundException("Fichero no encontrado");
        }
    }
    public void lee(Scanner sc){
        while(sc.hasNextLine()){
            agrega(creaBarcoString(sc.nextLine()));
        }
    }

    public void escribeFichero(String fic) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(fic)){
            escribe(pw);
        }
    }
    public void escribe(PrintWriter pw){
        Iterator<Barco> it = this.participantes.iterator();
        Barco b = null;
        while(it.hasNext()){
            b = it.next();
            pw.println(b.toString());
        }
    }
}
