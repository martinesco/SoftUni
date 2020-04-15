import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .limit(n)
                .forEach(numbers::offer);   //

        while (s-- >0){
            numbers.poll(); //
        }

        if (numbers.contains(x)){
            System.out.println("true");
        }
        else {
            if (numbers.isEmpty()){
                System.out.println(0);
            }else {

                System.out.println(Collections.min(numbers));

            }
        }


    }
}
