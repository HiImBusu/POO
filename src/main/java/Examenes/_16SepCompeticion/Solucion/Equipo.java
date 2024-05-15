package Examenes._16SepCompeticion.Solucion;

public class Equipo implements Comparable<Equipo>{
    private String nombre;
    private int categoria;
    private int puntos;

    public Equipo(String nom, int cat, int punt){
        if(cat < 1 || cat > 5)
            throw new CompeticionException("Categoria no valida");
        if(punt < 0)
            throw new CompeticionException("Puntos no valido");

        this.nombre = nom;
        this.categoria = cat;
        this.puntos = punt;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setCategoria(int categoria) {
        if(categoria < 1 || categoria > 5)
            throw new CompeticionException("Categoria no valida");

        this.categoria = categoria;
    }

    public void increPuntos(int ptos){
        if(ptos < 0)
            throw new CompeticionException("Puntos no valido");
        this.puntos = ptos;
    }


    @Override
    public String toString() {
        return String.format("%s:%d:%d", nombre, categoria, puntos);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Equipo e) &&
                this.nombre.equalsIgnoreCase(e.nombre) &&
                this.categoria == e.categoria &&
                this.puntos == e.puntos;
    }


    @Override
    public int compareTo(Equipo o) {
        int comp = Integer.compare(this.categoria, o.categoria);
        if(comp == 0)
            comp = Integer.compare(o.puntos, this.puntos); // Lo pongo al reves para que el orden sea inverso
        if(comp == 0)
            comp = this.nombre.compareToIgnoreCase(o.nombre);
        return comp;
    }
}
