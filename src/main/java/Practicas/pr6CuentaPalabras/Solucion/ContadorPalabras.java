package Practicas.pr6CuentaPalabras.Solucion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class ContadorPalabras {
    private List<PalabraEnTexto> palabras;

    public ContadorPalabras(){
        this.palabras = new ArrayList<>();
    }

    private int esta(String pal){
        int index = -1;
        for(int i = 0; i < this.palabras.size(); i++){
            if(this.palabras.get(i).equals(new PalabraEnTexto(pal))){
                index = i;
            }
        }
        return index;
    }
    protected void incluye(String pal){
        int index;
        if(!pal.isEmpty() && !pal.isBlank()){
            index = esta(pal);
            if(index == -1){
                this.palabras.add(new PalabraEnTexto(pal));
            }else{
                this.palabras.get(index).incrementa();
            }
        }
    }

    private void incluyeTodas(String linea, String del){
        Scanner sc = new Scanner(linea);
        sc.useDelimiter(del);
        while(sc.hasNext()){
            incluye(sc.next());
        }
    }
    public void incluyeTodas(String[] texto, String del){
        for(String linea : texto){
            incluyeTodas(linea, del);
        }
    }


    public void incluyeTodasFichero(String nomFich, String del) throws IOException {
        Scanner sc = new Scanner(Path.of(nomFich));
        while(sc.hasNextLine()){
            incluyeTodas(sc.nextLine(), del);
        }
        sc.close();
    }

    public PalabraEnTexto encuentra(String pal){
        int index = esta(pal);
        if(index == -1)
            throw new NoSuchElementException("No existe la palabra " + pal);

        return this.palabras.get(index);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" - ", "[", "]");
        for(PalabraEnTexto p : this.palabras){
            sj.add(p.toString());
        }
        return sj.toString();
    }


    public void presentaPalabras(String fichero) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(fichero);
        presentaPalabras(pw);
    }
    public void presentaPalabras(PrintWriter pw){
        for(PalabraEnTexto p : this.palabras){
            pw.println(p.toString());
        }
    }
}
