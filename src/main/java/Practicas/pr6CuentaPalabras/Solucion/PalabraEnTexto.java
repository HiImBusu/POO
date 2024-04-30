package Practicas.pr6CuentaPalabras.Solucion;

public class PalabraEnTexto {
    private String palabra;
    private int veces;

    public PalabraEnTexto(String pal){
        this.palabra = pal.toUpperCase();
        this.veces = 1;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof PalabraEnTexto p) &&
                this.palabra.equals(p.palabra);
    }

    @Override
    public String toString() {
        return String.format("%s: %d", this.palabra, this.veces);
    }

    public void incrementa(){
        this.veces++;
    }
}
