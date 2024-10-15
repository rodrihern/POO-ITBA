package taller.taller9.Ej1;

import taller.taller7.Citizen.Citizen;

import java.util.*;

public class CitizenTester {
    public static void main(String[] args) {
        Citizen korman = new Citizen(1, "Agustin", "Korman");
        Citizen rodri = new Citizen(2, "Rodrigo", "Hernandez");
        Citizen joaco = new Citizen(3, "Joaquin", "Nolasco");
        Citizen feli = new Citizen(4, "Felipe", "Villanueva");
        Citizen edu = new Citizen(5, "Eduardo", "Toroide");

        SortedMap<Integer, Citizen> citDni = new TreeMap<>();
        Map<String, List<Citizen>> citName = new HashMap<>();
        Map<String, Map<String, List<Citizen>>> citlastName = new HashMap<>();

        // para acceder por dni y ademas estan ordenados
        citDni.putIfAbsent(korman.getDni(), korman);
        citDni.putIfAbsent(feli.getDni(), feli);
        citDni.putIfAbsent(edu.getDni(), edu);

        // para acceder por nombre
        citName.putIfAbsent(joaco.getName(), new ArrayList<>());
        citName.get(joaco.getName()).add(joaco);

        // para acceder por nombre y apellido
        citlastName.putIfAbsent(rodri.getName(), new HashMap<>());
        citlastName.get(rodri.getName()).putIfAbsent(rodri.getLastName(), new ArrayList<>());
        citlastName.get(rodri.getName()).get(rodri.getLastName()).add(rodri);

    }
}
