package taller.taller7.Citizen;

import java.util.*;

public class CitizenCollection {
    public static void main(String[] args) {
        Set<Citizen> citizens = new HashSet<>();
        Citizen rodri = new Citizen(1, "Rodrigo", "Hernandez");
        Citizen korman = new Citizen(2, "Agustin", "Korman");
        Citizen joaco = new Citizen(3, "Joaco", "Nolasco");
        citizens.add(rodri);
        citizens.add(korman);
        citizens.add(joaco);

        citizens.add(new Citizen(2, "no", "agregar"));
        citizens.remove(new Citizen(3, "x", "y"));

        for(Citizen c : citizens) {
            System.out.println(c);
        }

        System.out.println("...............");

        SortedSet<Citizen> naturalCitizens = new TreeSet<>();
        naturalCitizens.add(korman);
        naturalCitizens.add(rodri);
        naturalCitizens.add(joaco);

        for(Citizen c : naturalCitizens) {
            System.out.println(c);
        }

        System.out.println("................");

        SortedSet<Citizen> reverseCitizens = new TreeSet<>(Comparator.reverseOrder());
        reverseCitizens.add(korman);
        reverseCitizens.add(rodri);
        reverseCitizens.add(joaco);

        for(Citizen c : reverseCitizens) {
            System.out.println(c);
        }









    }
}
