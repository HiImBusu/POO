package Examenes._22JunioProgramasTV.Solucion;

public class ProgramacionTVPublicidad extends ProgramacionTV{
    public ProgramacionTVPublicidad(){
        super();
    }

    @Override
    public void agregar(String cadenaTV, ProgramaTV prog) {
        super.agregar(cadenaTV, prog);
        super.agregar(cadenaTV, new ProgramaTV("Publicidad", prog.getHoraFin(), 5));
    }
}
