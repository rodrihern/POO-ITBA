package guias.guia2;

public class Histograma {
    public static void main(String[] args) {
        int[] intervals = new int[10];
        int max = 0;
        for(String s : args) {
            int i = Integer.valueOf(s) / 10;
            if(i < 0 || i >= 10) {
                System.out.println("el numero" + s + " es invalido");
            } else {
                intervals[i]++;
                if (intervals[i] > max) {
                    max = intervals[i];
                }
            }

        }
        printHist(intervals, max);

    }

    private static void printHist(int[] intervals, int max) {
        for(int i = max; i > 0; i--) {
            System.out.print("| ");
            for(int app : intervals) {
                System.out.print(app >= i ? "*" : " ");
                System.out.print(" | ");
            }
            System.out.println();
        }
        for(int app : intervals) {
            System.out.print("+---");
        }
        System.out.println("+");
        for(int i = 0; i <= 10; i++) {
            System.out.printf("%-4d", i*10);
        }
    }
}
