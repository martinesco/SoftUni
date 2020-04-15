import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] plants = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> indexesStack = new ArrayDeque<>();

        int[] days = new int[n];

        indexesStack.push(1);

        for (int i = 0; i < plants.length; i++) {

            int maxDays = 0;

            while (indexesStack.size() > 0
                    && plants[indexesStack.peek()] >= plants[i]) {

                maxDays = Math.max(maxDays, days[indexesStack.pop()]);
            }

            if (indexesStack.size() > 0) {
                days[i] = maxDays + 1;
            }
            indexesStack.push(i);

        }

        System.out.println(max(days));
    }

    private static int max(int[] days) {
        int max = Integer.MIN_VALUE;
        for (int day : days) {
            if (day > max) {
                max = day;
            }
        }
        return max;
    }
}
