package Practicas.pr6CuentaPalabras.Solucion;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContadorPalabrasSig extends ContadorPalabras{
    private List<String> noSignificativas;
    public ContadorPalabrasSig(){
        super();
        this.noSignificativas = new ArrayList<>();
    }
    public void leeArrayNoSig(String[] palsNS){
        this.noSignificativas.clear();

        for(String pal : palsNS){
            if(!pal.isBlank() && !pal.isEmpty()){
                this.noSignificativas.add(pal.toUpperCase());
            }
        }
    }

    public void leeFicheroNoSig(String filNoSig, String del) throws IOException {
        try(Scanner sc = new Scanner(Path.of(filNoSig))){
            while(sc.hasNextLine()){
                anyadePalabrasNoSignificativas(sc.nextLine(), del);
            }
        }
    }
    private void anyadePalabrasNoSignificativas(String linea, String del){
        try(Scanner sc = new Scanner(linea)){
            String pal;
            sc.useDelimiter(del);

            while(sc.hasNext()){
                pal = sc.next();
                if(!pal.isEmpty() && !pal.isBlank()){
                    this.noSignificativas.add(pal.toUpperCase());
                }
            }
        }
    }

    @Override
    protected void incluye(String pal) {
        if(estaNoSig(pal) == -1)
            super.incluye(pal);
    }

    private int estaNoSig(String pal){
        int index = -1;
        for(int i = 0; i < this.noSignificativas.size(); i++){
            if(this.noSignificativas.get(i).equals(pal)){
                index = i;
            }
        }
        return index;
    }
}
