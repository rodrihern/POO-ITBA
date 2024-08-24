package guias.guia2;

public class Palindromo {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        for(String s : args) {
            str.append(s);
        }
        if(esPalindromo(str.toString())) {
            System.out.println("es palindromo");
        } else {
            System.out.println("no es palindromo");
        }
    }


    private static boolean esPalindromo(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}


