package Examenes._20JunioDados.Solucion;

import java.util.Set;

public class MainCubilete {
    public static void main(String[] args) {
        Cubilete c = new Cubilete(5);
        Set<Dado> dados = c.tira();
        boolean al_menos_un_6 = false;
        for(Dado d : dados){
            System.out.println(d);
            if(d.getCara() == 6){
                al_menos_un_6 = true;
            }
        }
        if(al_menos_un_6){
            System.out.println("-- Ha salido al menos un 6 :)");
        }else{
            System.out.println("-- No ha salido ningun 6 :(");
        }
    }
}
