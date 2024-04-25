package Examenes._20JunioDados.Solucion;

import java.util.Set;

public class JuegoB extends Juego{

    private int numDados;
    private int numSeises;

    public JuegoB(int n, int numSeises){
        if(n <= 0 || numSeises <= 0)
            throw new IllegalArgumentException();

        this.numDados = n;
        this.numSeises = numSeises;
    }

    @Override
    public int simula() {
        Cubilete c = new Cubilete(this.numDados);
        int numSeisesEncontrados = 0;
        int contador = 1;
        Set<Dado> resultados = c.tira();
        numSeisesEncontrados += cuentaSeises(resultados);
        while(numSeisesEncontrados < this.numSeises){
            resultados = c.tira();
            numSeisesEncontrados += cuentaSeises(resultados);
            contador++;
        }
        return contador;
    }

    private int cuentaSeises(Set<Dado> dados){
        int contador = 0;
        for(Dado d : dados){
            if(d.getCara() == 6){
                contador++;
            }
        }
        return contador;
    }
}
