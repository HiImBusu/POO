package Examenes._16JunioAsignaciones.Solucion;

import Examenes._16JunioAsignaciones.FranjaHoraria;

public class PruebaPeticionAsignacion {
    public static void main(String[] args) {
        try{
            PeticionAsignacion p1 = new PeticionAsignacion("Juan Lopez", "POO", new FranjaHoraria("Lunes", "Primera"));
            PeticionAsignacion p2 = new PeticionAsignacion("Maria Gomez", "FP", new FranjaHoraria("Lunes", "Primera"));
            System.out.println(p1);
            System.out.println(p2);
            if(p1.equals(p2)){
                System.out.printf("Conflico: %s a %s hora\n", p1.getFranja().getDia(), p1.getFranja().getHora());
            }else{
                System.out.println("No hay conflicto");
            }
            p1.setFranja(new FranjaHoraria("Lune", "Primera"));
        }catch (AsignacionException ex){
            System.out.println(ex.getMessage());
        }
    }
}
