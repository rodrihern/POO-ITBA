package taller.taller9.Ej2;

import taller.taller7.Citizen.Citizen;

public class CitizenBookTester {

    public static void main(String[] args) {
        Citizen sherlock = new Citizen(123, "Sherlock", "Holmes");
        Citizen john = new Citizen(456, "Dr. John", "Watson");
        Citizen mycroft = new Citizen(789, "Mycroft", "Holmes");

        CitizenBook cb = new CitizenBook();

        cb.add(sherlock);
        cb.add(john);
        cb.add(mycroft);

        // Todos los Holmes, ordenado alfabéticamente por nombre
        for(Citizen c : cb.getByLastName("Holmes")) {
            System.out.println(c);
        }

        System.out.println(cb.getByLastName("Lestrade").isEmpty()); // true
    }

}