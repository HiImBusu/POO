package Examenes._21JunioCovid.Solucion;

public class DistritoSanitario implements Comparable<DistritoSanitario>{
    private String distrito;
    private int poblacion;
    private int casosCOVID14dias;

    public DistritoSanitario(String nom, int pob, int casos){
        if(pob <= 0)
            throw new COVIDException("Poblacion negativa");
        if(casos < 0)
            throw new COVIDException("Casos negativos");

        this.distrito = nom;
        this.poblacion = pob;
        this.casosCOVID14dias = casos;
    }

    public String getDistrito() {
        return distrito;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public int getCasosCOVID14dias() {
        return casosCOVID14dias;
    }

    public void setCasosCOVID14dias(int casosCOVID14dias) {
        if(casosCOVID14dias < 0)
            throw new COVIDException("Casos negativos");
        this.casosCOVID14dias = casosCOVID14dias;
    }
    public int incidenciaAcumulada(){
        float tasa_incidencia = (float) casosCOVID14dias/poblacion;
        return Math.round(tasa_incidencia * 100000);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof DistritoSanitario s) &&
                (this.distrito.equalsIgnoreCase(s.distrito));
    }

    @Override
    public int compareTo(DistritoSanitario o) {
        return this.distrito.compareToIgnoreCase(o.distrito);
    }

    @Override
    public String toString() {
        return String.format("Distrito(%s, %d)", distrito, casosCOVID14dias);
    }
}
