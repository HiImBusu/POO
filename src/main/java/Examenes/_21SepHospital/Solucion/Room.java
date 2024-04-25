package Examenes._21SepHospital.Solucion;

public class Room implements Comparable<Room>{
    private int floor;
    private int number;

    public Room(int floor, int number){
        this.floor = floor;
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Room r) &&
                this.number == r.number &&
                this.floor == r.floor;
    }

    @Override
    public String toString() {
        return String.format("Room [floor=%d, number=%d]", this.floor, this.number);
    }

    @Override
    public int compareTo(Room o) {
        int comp = Integer.compare(this.floor, o.floor);
        if(comp == 0)
            comp = Integer.compare(this.number, o.number);
        return comp;
    }
}
