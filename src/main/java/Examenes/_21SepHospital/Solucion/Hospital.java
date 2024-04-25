package Examenes._21SepHospital.Solucion;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class Hospital {
    private String name;
    private int floors;
    protected  Map<Patient, Room> rooms;
    protected SortedSet<Room> free;

    public Hospital(String name, int floors, int rooms) throws HospitalException {
        if(name.isEmpty() || name.isBlank())
            throw new HospitalException("Nombre de hospital no valido");
        if(floors < 0)
            throw new HospitalException("Numero de plantas negativo");
        if(rooms < 0)
            throw new HospitalException("Numero de habitaciones negativo");

        this.name = name;
        this.floors = floors;
        this.rooms = new HashMap<>();
        this.free = new TreeSet<>();
        // Creamos las habitaciones todas libres
        for(int i = 1; i <= floors; i++){
            for(int j = 1; j <= rooms; j++){
                this.free.add(new Room(i, j));
            }
        }
    }

    public void checkIn(Patient p) throws HospitalException {
        if(p == null)
            throw new HospitalException("Paciente nulo");

        if(this.rooms.get(p) != null)
            throw new HospitalException("El paciente ya tiene una habitacion asignada");

        if(this.free.isEmpty())
            throw new HospitalException("No quedan habitaciones disponibles");

        Room habitacion_asignada = this.free.first();
        this.free.remove(habitacion_asignada);
        this.rooms.put(p, habitacion_asignada);
    }

    public Patient checkOut(String ssn){
        // Buscamos el paciente entre las habitaciones
        Patient pat = searchPatient(ssn);
        Room r;
        if(pat != null){
            // Si el paciente esta en la lista de habitaciones ocupadas
            r = this.rooms.get(pat);
            this.rooms.remove(pat);
            if(r != null){
                // Si tenia alguna habitacion asignadsa
                this.free.add(r);
            }
        }
        return pat;
    }

    private Patient searchPatient(String ssn){
        Patient pat = null;
        for(Patient p : this.rooms.keySet()){
            if(p.getSsn().equalsIgnoreCase(ssn)){
                pat = p;
            }
        }
        return pat;
    }

    public Patient[] selection(Criterion c){
        List<Patient> list = new ArrayList<Patient>();
        for(Map.Entry<Patient, Room> entry : this.rooms.entrySet()){
            if(c.meetsCondition(entry.getKey(), entry.getValue())){
                list.add(entry.getKey());
            }
        }
        return list.toArray(new Patient[0]);
    }

    public void readPatients(String filename) throws HospitalException {
        try(Scanner sc = new Scanner(Path.of(filename))){
            readPatients(sc);
        }catch (IOException ex){
            throw new HospitalException("No se ha podido abrir el fichero");
        }
    }
    private void readPatients(Scanner sc) throws HospitalException {
        while(sc.hasNextLine()){
            procesar(sc.nextLine());
        }
    }
    private void procesar(String linea) throws HospitalException {
        String name, surname, ssn;
        int birthDate;
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter("\\s*[,]\\s*");
            name = sc.next();
            surname = sc.next();
            ssn = sc.next();
            birthDate = sc.nextInt();

            // Meterlo en el diccionario sin habitacion asignada
            // SOLO SI EL PACIENTE NO ESTABA YA EN LA LISTA!
            Patient patient = new Patient(name, surname, ssn, birthDate);
            if(this.rooms.get(patient) == null)
                this.rooms.put(patient, null);


        }catch (InputMismatchException ex){
            throw new HospitalException("Error al convertir un dato en linea: " + linea);
        }catch (NoSuchElementException ex){
            throw new HospitalException("Error de formato en linea: " + linea);
        }
    }

    public void writePatients(String f) throws HospitalException {
        try (PrintWriter pw = new PrintWriter(f)){
            writePatients(pw);
        }catch (IOException ex){
            throw new HospitalException("No se ha podido crear el fichero");
        }
    }
    private void writePatients(PrintWriter pw){
        pw.printf("Hospital: %s\n", this.name);
        pw.printf("Numero de plantas: %d\n", this.floors);
        pw.println("Habitaciones disponibles: ");
        for(Room r : this.free){
            pw.printf("\t%s\n", r);
        }
        pw.println("Habitaciones ocupadas: ");
        for(Map.Entry<Patient, Room> entry : this.rooms.entrySet()){
            if(entry.getValue() == null){
                pw.printf("\t%s -> SIN HABITACION ASIGNADA\n", entry.getKey());
            }else{
                pw.printf("\t%s -> %s\n", entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Hospital [name=%s, rooms=%s, free=%s]",
                this.name, this.rooms, this.free);
    }
}
