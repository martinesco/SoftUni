import java.util.Scanner;

public class RecursiveFactorial {

    static long factoriel(int n){
        if (n==0) return 1;
        return n*factoriel(n-1);
    }
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
       // factoriel(scanner.nextInt());
        System.out.println(factoriel(scanner.nextInt()));
    }
}
