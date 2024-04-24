package Examenes._21JunioCovid.Solucion;

public class PruebaDistritoSanitario {
    public static void main(String[] args) {
        args = new String[]{"300", "500", "200", "1000", "3000", "500"};
        try{
            DistritoSanitario d1 = new DistritoSanitario("La Vega", 110176, Integer.parseInt(args[0]));
            DistritoSanitario d2 = new DistritoSanitario("Axarquia", 170141, Integer.parseInt(args[1]));
            DistritoSanitario d3 = new DistritoSanitario("Valle del Guadalhorce", 156298, Integer.parseInt(args[2]));
            DistritoSanitario d4 = new DistritoSanitario("Costa del Sol", 560785, Integer.parseInt(args[3]));
            DistritoSanitario d5 = new DistritoSanitario("Málaga Distrito", 633521, Integer.parseInt(args[4]));
            DistritoSanitario d6 = new DistritoSanitario("Serrania", 54999, Integer.parseInt(args[5]));
        }catch (IndexOutOfBoundsException ex){
            System.err.println("No se proporciona valores suficientes como argumentos en el main");
        } catch (NumberFormatException ex){
            System.err.println("Alguno de los valores introducidos no se corresponde con un numero entero");
        } catch (COVIDException ex){
            System.err.println("Alguno de los valores introducidos es negativo");
        }
    }
}
