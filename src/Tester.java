import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        int[] intArray = new int[4];
        String[] words = new String[]{"hola", "que", "tal"};
        System.out.println(Arrays.toString(intArray));
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));
    }

}

