package taller.taller7.Citizen;

import java.util.Objects;

public class Citizen implements Comparable<Citizen> {
    private final int dni;
    private final String name, lastName;

    public Citizen(int dni, String name, String lastName) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
    }

    public int getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Citizen c && this.dni == c.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }

    @Override
    public int compareTo(Citizen o) {
        return this.dni - o.dni;
    }
}
