package Examenes._20JunioDados.Solucion;

import java.util.Set;

public class JuegoA extends Juego{
    // Juega hasta que la suma de los dados den un determinado valor
    private int numDados;
    private int sumaBuscada;

    public JuegoA(int n, int suma){
        if(n <= 0 || suma < n || suma > 6 * n)
            throw new IllegalArgumentException();

        this.numDados = n;
        this.sumaBuscada = suma;
    }


    @Override
    public int simula() {
        Cubilete c = new Cubilete(this.numDados);
        int contador = 1;
        Set<Dado> resultados = c.tira();
        while(sumaDados(resultados) != this.sumaBuscada){
            resultados = c.tira();
            contador++;
        }
        return contador;
    }

    private int sumaDados(Set<Dado> dados){
        int suma = 0;
        for(Dado d : dados){
            suma += d.getCara();
        }
        return suma;
    }
}
