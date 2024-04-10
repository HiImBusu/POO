package Practicas.pr3LibreriaExtendida;

public class LibreriaOfertaFlex extends Libreria{
    // Atributo
    private OfertaFlex oferta;

    // Metodo
    public LibreriaOfertaFlex(OfertaFlex of){
        setOferta(of);
    }

    public void setOferta(OfertaFlex of){
        oferta = of;
    }

    public OfertaFlex getOferta(){
        return oferta;
    }

    @Override
    public void addLibro(String aut, String tit, double pre) {
        // Compruebo si el libro esta en oferta o no
        Libro lib = new Libro(aut, tit, pre);
        double desc = this.oferta.getDescuento(lib);

        if(desc < 0.0){
            throw  new RuntimeException();
        }else if(desc > 0.0) {
            lib = new LibroOferta(aut, tit, pre, desc);
        }
        anyadirLibro(lib);
    }

    @Override
    public String toString() {
        return String.format("%s\n%s", oferta, super.toString());
    }
}
