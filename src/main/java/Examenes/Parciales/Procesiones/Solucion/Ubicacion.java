package Examenes.Parciales.Procesiones.Solucion;

public class Ubicacion {
    private String nombre;
    private int minutos;
    private int distancia;
    public Ubicacion(String nom, int min, int dist){
        if(dist < 0)
            throw new ProcesionesException("La distancia desde la salida no puede ser negativa");

        this.nombre = nom;
        this.minutos = min;
        this.distancia = dist;
    }
    public Ubicacion(String nom){
        this(nom, 0, 0);
    }

    public String getNombre() {
        return nombre;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setDistancia(int distancia) {
        if(distancia < 0)
            throw new ProcesionesException("La distancia desde la salida no puede ser negativa");

        this.distancia = distancia;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Ubicacion ub) &&
                this.nombre.equalsIgnoreCase(ub.nombre);
    }

    @Override
    public String toString() {
        return String.format("%s(%d', %dm)", nombre, minutos, distancia);
    }
}
