package Examenes._20JunioDados.Solucion;

import java.util.HashSet;
import java.util.Set;

public class Cubilete {
    private Set<Dado> dados;
    public Cubilete(int n_dados){
        if(n_dados <= 0)
            throw new IllegalArgumentException();

        this.dados = new HashSet<>();
        for(int i = 1; i <= n_dados; i++){
            this.dados.add(new Dado());
        }
    }
    public Set<Dado> tira(){
        for(Dado d : this.dados){
            d.agita();
        }
        return this.dados;
    }
}
