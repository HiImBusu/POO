package Examenes._21SepHospital.Solucion;

public class SameFloor implements Criterion{
    private int floor;
    public SameFloor(int floor){
        this.floor = floor;
    }

    @Override
    public boolean meetsCondition(Patient p, Room r) {
        return r.getFloor() == this.floor;
    }
}
