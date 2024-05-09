package Examenes._17SepRedSocial.Solucion;

public class Mensaje implements Comparable<Mensaje>{
    private static int cntSecuencia = 1;
    private int secuencia;
    private String emisor;
    private String receptor;
    private String texto;

    public Mensaje(String e, String r, String txt){
        if(e.isEmpty() || e.isBlank())
            throw new AppException("El emisor no es valido");

        if(r.isEmpty() || r.isBlank())
            throw new AppException("El receptor no es valido");

        if(txt.isEmpty() || txt.isBlank())
            throw new AppException("El texto no es valido");

        this.emisor = e;
        this.receptor = r;
        this.texto = txt;
        this.secuencia = cntSecuencia;
        cntSecuencia++;
    }

    public String getEmisor() {
        return emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return String.format("(%s; %s; %s)", this.emisor, this.receptor, this.texto);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Mensaje m) &&
                this.secuencia == m.secuencia &&
                this.emisor.equalsIgnoreCase(m.emisor) &&
                this.receptor.equalsIgnoreCase(m.receptor);
    }

    @Override
    public int compareTo(Mensaje o) {
        int comp = Integer.compare(this.secuencia, o.secuencia);
        if(comp == 0)
            comp = this.emisor.compareToIgnoreCase(o.emisor);
        if(comp == 0)
            comp = this.receptor.compareToIgnoreCase(o.receptor);
        return comp;
    }
}
