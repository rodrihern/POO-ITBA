package taller.taller13;

import java.util.Collection;
import java.util.SortedMap;

public class SpecialMapTester {
    public static void main(String[] args) {
        // Se instancia un SpecialMap de clave String y valor Integer
        SpecialMap<String, Integer> stringIntegerMap = new SpecialMap<>();


        stringIntegerMap.put("Hola", 1);
        stringIntegerMap.put("Mundo", 3);
        stringIntegerMap.put("Hello", 1);
        stringIntegerMap.put("World", 3);
        stringIntegerMap.put("Mondo", 3);


        // Se obtiene un nuevo mapa de clave Integer y valor colección de String
        // donde las claves tienen orden natural
        // y la colección de valores no tiene orden
       SortedMap<Integer, Collection<String>> m1 = stringIntegerMap.groupByValue();
        System.out.println(m1.size()); // 2
        // Se obtiene la primera (menor) clave
        System.out.println(m1.firstKey()); // 1
        // Se obtiene la última (mayor) clave
        System.out.println(m1.lastKey()); // 3
        System.out.println(m1.get(1)); // [Hello, Hola] en cualquier orden
        System.out.println(m1.get(3)); // [Mundo, Mondo, World] en cualquier orden


        // Se obtiene un nuevo mapa de clave Integer y valor colección de String
        // donde las claves tienen orden inverso al natural
        // y la colección de valores no tiene orden
       SortedMap<Integer, Collection<String>> m2 = stringIntegerMap.groupByValueReversed();
        System.out.println(m2.size()); // 2
        System.out.println(m2.firstKey()); // 3
        System.out.println(m2.lastKey()); // 1
        System.out.println(m2.get(3)); // [Mundo, Mondo, World] e
        System.out.println(m2.get(1)); // [Hello, Hola] en cualquier orden


        // Se instancia un SpecialMap de clave Planet y valor String
        SpecialMap<Planet, String> planetStringMap = new SpecialMap<>();


        planetStringMap.put(new Planet("Mercury"), "Foo");
        planetStringMap.put(new Planet("Venus"), "Bar");
        planetStringMap.put(new Planet("Earth"), "Foo");
        planetStringMap.put(new Planet("Mars"), "FooBar");
        planetStringMap.put(new Planet("Jupiter"), "Bar");


       SortedMap<String, Collection<Planet>> m3 = planetStringMap.groupByValue();
        System.out.println(m3.size()); // 3
        System.out.println(m3.firstKey()); // Bar
        System.out.println(m3.lastKey()); // FooBar
        System.out.println(m3.get("Bar")); // [Planet Venus, Planet Jupiter] en cualquier orden
        System.out.println(m3.get("Foo")); // [Planet Earth, Planet Mercury] en cualquier orden
        System.out.println(m3.get("FooBar")); // [Planet Mars] en cualquier orden


       SortedMap<String, Collection<Planet>> m4 = planetStringMap.groupByValueReversed();
        System.out.println(m4.size()); // 3
        System.out.println(m4.firstKey()); // FooBar
        System.out.println(m4.lastKey()); // Bar
        System.out.println(m4.get("FooBar")); // [Planet Mars] en cualquier orden
        System.out.println(m4.get("Foo")); // [Planet Earth, Planet Mercury] en cualquier orden
        System.out.println(m4.get("Bar")); // [Planet Venus, Planet Jupiter] en cualquier orden
    }




    static class Planet {
        private final String name;


        public Planet(String name) {
            this.name = name;
        }


        @Override
        public String toString() {
            return "Planet %s".formatted(name);
        }
    }

}
