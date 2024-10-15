package taller.taller9.Ej2;

import taller.taller7.Citizen.Citizen;

import java.util.*;

public class CitizenBook {
    private Map<String, SortedSet<Citizen>> book = new HashMap<>();

    public void add(Citizen citizen) {
        book.putIfAbsent(citizen.getLastName(), new TreeSet<>(((o1, o2) -> o1.getName().compareTo(o2.getName()))));
        book.get(citizen.getLastName()).add(citizen);
    }

    public Collection<Citizen> getByLastName(String lastName) {
        return book.getOrDefault(lastName, new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName())));
    }
}
