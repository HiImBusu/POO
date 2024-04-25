package Examenes._21SepHospital.Solucion;

import java.util.Objects;

public class Patient implements Comparable<Patient> {
    private String name;
    private String surname;
    private String ssn;
    private int birthYear;

    public Patient(String name, String surn, String numb, int year) throws HospitalException {
        if(name.isEmpty() || surn.isEmpty() || numb.isEmpty())
            throw new HospitalException("Valor nulo");

        if(numb.length() != 10)
            throw new HospitalException("SSN debe de tener 10 caracteres");

        if(!checkDigitControlSSN(numb))
            throw new HospitalException("SSN no valido");

        this.name = name;
        this.surname = surn;
        this.ssn = numb;
        this.birthYear = year;
    }
    private boolean checkDigitControlSSN(String numb){
        int provCodeUniqueId = Integer.parseInt(numb.substring(0, 8));
        int control = Integer.parseInt(numb.substring(8, 10));
        return provCodeUniqueId % 97 == control;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSsn() {
        return ssn;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Patient p) &&
                this.name.equalsIgnoreCase(p.name) &&
                this.surname.equalsIgnoreCase(p.surname) &&
                this.ssn.equals(p.ssn) &&
                this.birthYear == p.birthYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name.toLowerCase(), this.surname.toLowerCase(), this.ssn, this.birthYear);
    }

    @Override
    public String toString() {
        return String.format("Patient [name=%s, surname=%s, ssn=%s, birthYear=%d]", this.name, this.surname, this.ssn, this.birthYear);
    }

    @Override
    public int compareTo(Patient o) {
        int comp = Integer.compare(this.birthYear, o.birthYear);
        if(comp == 0)
            comp = this.ssn.compareToIgnoreCase(o.ssn);
        if(comp == 0)
            comp = this.surname.compareToIgnoreCase(o.surname);
        if(comp == 0)
            comp = this.name.compareToIgnoreCase(o.name);
        return comp;
    }
}

