package Examenes._16SepCompeticion.Solucion;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

public class CompeticionMaster extends Competicion{
    private final int umbral;
    public CompeticionMaster(String fic, int umb) throws FileNotFoundException {
        super();
        umbral = umb;
        leerDatos(fic);
    }

    @Override
    public void insertaJugadoresEquipo(Equipo eq, List<Jugador> jugadores) {
        Iterator<Jugador> it = jugadores.iterator();
        Jugador jug;
        while(it.hasNext()){
            jug = it.next();
            if(jug.getpGanados() < this.umbral){
                it.remove();
            }
        }
        super.insertaJugadoresEquipo(eq, jugadores);
    }
}
