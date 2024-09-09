package guias.guia5.Pair;

import java.util.Arrays;
import java.util.Comparator;

public class PairTester {
    public static void main(String[] args) {
        Pair<String, Double> stringDoublePair = new Pair<>("hola", 0.1);
        System.out.println(stringDoublePair);
        Pair<Integer, Integer> integerIntegerPair = new Pair<>(1, 2);
        System.out.println(integerIntegerPair);
        System.out.println(stringDoublePair.equals(new Pair<>("hola", 0.1)));

        Pair<String, String> stringPair1 = new Pair<>("hola", "mundo");
        Pair<String, String> stringPair2 = new Pair<>("hola", "adiós");
        Pair<String, String> stringPair3 = new Pair<>("buen", "día");
        Pair pairArray[] = new Pair[]{stringPair1, stringPair2, stringPair3};
        Arrays.sort(pairArray, Comparator.reverseOrder());
        System.out.println(Arrays.toString(pairArray));

    }

}
