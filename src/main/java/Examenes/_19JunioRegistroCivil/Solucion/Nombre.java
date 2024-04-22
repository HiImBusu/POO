package Examenes._19JunioRegistroCivil.Solucion;

public class Nombre implements Comparable<Nombre>{
    // Atributos
    private char genero;
    private String nombre;

    public Nombre(char gen, String nom){
        if((gen != 'F' && gen != 'M') || nom.isEmpty())
            throw new RegistroCivilException();

        this.genero = gen;
        this.nombre = nom;
    }

    public char getGenero() {
        return genero;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Nombre n) && nombre.equalsIgnoreCase(n.nombre) &&
                this.genero == n.genero;
    }

    @Override
    public int compareTo(Nombre o) {
        int comp = this.nombre.compareToIgnoreCase(o.nombre);
        if(comp == 0)
            comp = Character.compare(this.genero, o.genero);
        return comp;
    }

    @Override
    public String toString() {
        return String.format("(%s, %c)", this.nombre, this.genero);
    }
}
