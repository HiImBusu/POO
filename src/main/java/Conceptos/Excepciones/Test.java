package Conceptos.Excepciones;

public class Test {
    /*
    * Definicion: Se usan para INFORMAR de que algo en el programa ha ido mal. Si dichas excepciones
    *   no son capturadas se PARARA el programa y se informara de la excepcion lanzada, la linea de codigo
    *   donde se lanzo y la traza de ejecución que llevabas cuando la lanzaste
    *
    * Capturar excepciones: try { .... } catch (Exception e) { ... } finally { ... }
    *
    * Anunciar excepciones: Poner en la cabecera de la funcion que puede lanzar la excepcion "throws ....."
    *
    * Tipos:
    *   - Comprobadas (DEBEN DE SER TRATADAS O ANUNCIADAS):
    *       Representan situaciones que se puede esperar que ocurran.
    *   - No comprobadas (PUEDE O NO SER TRATADA O ANUNCIADA):
    *       Representan situaciones de las cuales no es posible recuperarse de forma razonable
    *
    * Clases de excepciones "basicas"
    * Exception: Comprobada (FUNDAMENTAL)
    * IOException: Comprobada
    * FileNotFoundException: Comprobada
    * RuntimeException: No comprobada (FUNDAMENTAL)
    * IndexOutOfBoundsExcepcion: No comprobada
    * NumberFormatException: No comprobada
    * NullPointerException: No comprobada
    *
    * Ejemplos:
    *   1. Crear una excepcion controlada llamada "EdadNegativaException" y lanzarla anunciandola
    *   2. Con la excepcion de antes lanzarla, capturarla y cambiar la edad por un 0
    *   3. Crear una excepcion NO controlada llamada "DemasiadoViejoException". La cual no necesitaremos
    *       que sea ni anunciada ni capturada
    *
    * */
    public static void main(String[] args) {
        int edad = 10;

        // Ejemplo 1

        // Ejemplo 2

        // Ejemplo 3
    }

}
