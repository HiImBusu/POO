package Examenes._21SepHospital.Solucion;

public class BornBefore implements Criterion{
    private int year;
    public BornBefore(int year){
        this.year = year;
    }

    @Override
    public boolean meetsCondition(Patient p, Room r) {
        return p.getBirthYear() <= this.year;
    }
}
