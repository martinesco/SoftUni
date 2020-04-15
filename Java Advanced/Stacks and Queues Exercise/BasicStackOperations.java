import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();  //to PUSH
        int s = scanner.nextInt(); //to POP
        int x = scanner.nextInt();  //ima li go
        scanner.nextLine();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .limit(n)
                .forEach(numbers::push);

        while (s-- > 0) {
            numbers.pop();
        }

        if (numbers.contains(x)) {
            System.out.println("true");
        } else {
            if (numbers.size() == 0) {
                System.out.println(0);
            } else {

                // System.out.println(Collections.min(numbers));

                int min = Integer.MAX_VALUE;
                while (!numbers.isEmpty()) {

                    int number = numbers.pop();
                    if (min > number) {
                        min = number;
                    }
                }
                System.out.println(min);
            }

        }


    }
}
