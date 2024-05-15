package Examenes._16SepCompeticion.Solucion;

public class Jugador {
    private String nombre;
    private int pJugados;
    private int pGanados;

    public Jugador(String nom, int pJug, int pGan){
        if(pJug < 0 || pGan < 0)
            throw new CompeticionException("Partidos jugados/ganados no validos");

        if(pGan > pJug)
            throw new CompeticionException("Partidos ganados superior a partidos jugados");

        this.nombre = nom;
        this.pJugados = pJug;
        this.pGanados = pGan;
    }
    public Jugador(String nom){
        this(nom, 0, 0);
    }

    public String getNombre() {
        return nombre;
    }

    public int getpJugados() {
        return pJugados;
    }

    public int getpGanados() {
        return pGanados;
    }
    public void increPartidos(int pJug, int pGan){
        if(pJug < 0 || pGan < 0)
            throw new CompeticionException("Partidos jugados/ganados no validos");

        if(pGan > pJug)
            throw new CompeticionException("Partidos ganados superior a partidos jugados");

        this.pJugados += pJug;
        this.pGanados += pGan;
    }

    @Override
    public String toString() {
        return String.format("%s:%d:%d", nombre, pJugados, pGanados);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Jugador j) &&
                this.nombre.equalsIgnoreCase(j.nombre);
    }
}
