package Examenes.Parciales.Procesiones.Solucion;

public class PruebaUbicacion {
    public static void main(String[] args) {
        try{
            Ubicacion ub1 = new Ubicacion("Larios", 210, 1000);
            Ubicacion ub2 = new Ubicacion("Molina Larios", 270, 1900);
            System.out.println(ub1);
            System.out.println(ub2);
            if(ub1.equals(ub2)){
                System.out.println("Son iguales");
            }else{
                System.out.println("Son distintas");
            }

            Ubicacion ub3 = new Ubicacion(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));


        }catch (IndexOutOfBoundsException ex){
            System.err.println("No se proporcionan los suficientes datos");
        }catch (NumberFormatException ex){
            System.err.println("El formato de alguno de los argumentos no es correcto");
        }catch (ProcesionesException ex){
            System.err.println(ex.getMessage());
        }
    }
}
