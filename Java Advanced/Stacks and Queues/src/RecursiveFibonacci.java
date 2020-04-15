import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {

    private static long [] memory;

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int number = Integer.parseInt(scanner.nextLine());
        memory = new long[number+1];


        long result = getFibonacci(number);

        System.out.println(result);

    }
    private static long getFibonacci(int n){
        if (n<2){
            return 1;
        }

        if (memory[n] !=0){
            return memory[n];
        }

        return memory[n] = getFibonacci(n-1) + getFibonacci(n-2);

    }
}
