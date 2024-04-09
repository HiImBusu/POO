package Conceptos.ClasesPredefinidas;

public class Test {
    /*
    * Paquetes de java principales:
    *   -> java.lang:
    *       * Object: TODAS las clases HEREDAN de esta clase, la cual tiene 3 metodos principales
    *           - String toString()
    *           - boolean equals(Object o)
    *           - int hashCode()
    *       * StringBuilder:
    *           - String: Para cadenas INMUTABLES (no van a cambiar)
    *               Metodos basicos
    *                   int length(): Longitud de la cadena
    *                   char charAt(int pos): Letra que esta en la posicion 'pos' [0...length - 1]
    *                       * Si te sales del array saltara una excepcion "IndexOutOfBoundsException"
    *               Comparaciones: String c1, String c2
    *                   c1.equals(c2): Igualdad exacta
    *                   c1.equalsIgnoreCase(c2): Igualdad sin tener en cuenta mayusculas/minusculas (RECOMENDADA)
    *                   c1.compareTo(c2): Devuelve -1 si c1 es menor que c2, 0 si son iguales y 1 si c1 es mayor que c2
    *                   c1.compareToIgnoreCase(c2): Igual que el anterior pero sin tener en cuenta mayusculas o minusculas
    *                   c1 == c2: Error!! Compara las referencias (NO SERVIRA PARA NADA)
    *               Metodos que producen nuevos strings
    *                   String substring(int posini, int posfin): Devuelve una subcadena
    *                   String replace(String str1, String str2): Sustituye cada vez que aparezca 'str1' por 'str2'
    *                   String concat(String s): Concatena 's' al final de la cadena
    *                   String toUpperCase()/toLowerCase(): Pasar a mayusculas/minusculas la cadena
    *                   static String format(...): Formatea una cadena (RECOMENDADO)
    *                   String[] split(String delimitadores): Parte la cadena en un array de cadenas donde usa 'demilimitadores' como el separador
    *
    *          - StringBuilder: Para cadenas MUTABLES (quieres ir modificandolas)
    *
    * */
    public static void main(String[] args) {
        System.out.println("-- Object (Ejemplos)");


        System.out.println("\n-- String/StringBuilder (Ejemplos)");
        String str = "Hola marco!";
        // str = "Adios marco!"; ESTO NO DEBEMOS HACERLO PORQUE ES INMUTABLE. HACE COPIAS Y DESPERDICIA MEMORIA!!!!




    }
}
