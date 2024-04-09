package Conceptos.ClasesPredefinidas.Object;

import java.util.Objects;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(String n, int e){
        nombre = n;
        edad = e;
    }

    @Override
    public String toString() {
        // Como se imprime por pantalla
        return String.format("Nombre: %s Edad: %d", nombre, edad);
    }

    @Override
    public boolean equals(Object obj) {
        // Como se COMPARAN dos objetos de tipo "Persona"
        boolean res = false;
        if(obj instanceof Persona){
            Persona p = (Persona) obj; // Hacemos el casting a la clase persona
            res = edad == p.edad && nombre.equalsIgnoreCase(p.nombre);
        }
        return res;
    }

    @Override
    public int hashCode() {
        // Importante para las tablas HASH que veremos mas adelante..
        // En resumen, cada instancia de la clase debe de devolver un numero que la representa
        // Debe de cumplir dos premisas:
        //      - Si dos objetos son iguales, deben de devolver el mismo HASH
        //      - Dos objetos diferentes pueden devolver el mismo HASH
        // Conejo util: usar las clases predefinidas de las clases envolventes
        //      Double.hashCode(...)
        //      Integer.hashCode(...)
        // O utilizar el de la clase Objects que tambien funciona muy bien

        int hash1 = nombre.hashCode() + Integer.hashCode(edad);

        // Podemos usar operaciones diferentes
        int hash2 = nombre.hashCode() * Integer.hashCode(edad);

        // Si se trata de un entero puedo usarlo directamente
        int hash3 = nombre.hashCode() + edad;

        // CUIDADO! Si usas el ignoreCase en el equals debes de trasnsformarl la
        // cadena a minusculas/mayusculas tambien.
        int hash4 = nombre.toLowerCase().hashCode() + edad;

        // Podemos usar la clase Objets tambien
        int hash5 = Objects.hash(nombre.toLowerCase(), edad);

        return hash1;
    }
}
