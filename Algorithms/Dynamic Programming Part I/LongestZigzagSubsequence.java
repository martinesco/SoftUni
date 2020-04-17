import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LongestZigzagSubsequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[input.length][2];

        int[][] prev = new int[input.length][2];

        dp[0][0] = dp[0][1] = 1;
        prev[0][0] = prev[0][1] = -1;

        int maxResult = 0;
        int maxIndexRow = 0;
        int maxIndexCol = 0;

        for (int currentIndex = 1; currentIndex < input.length; currentIndex++) {

            for (int prevIndex = 0; prevIndex < currentIndex; prevIndex++) {

                int currentNumber = input[currentIndex];
                int prevNumber = input[prevIndex];

                if (currentNumber > prevNumber &&
                        dp[currentIndex][0] < dp[prevIndex][1] + 1) {
                    dp[currentIndex][0] = dp[prevIndex][1] + 1;
                    prev[currentIndex][0] = prevIndex;
                }
                if (currentNumber < prevNumber &&
                        dp[currentIndex][1] < dp[prevIndex][0] + 1) {
                    dp[currentIndex][1] = dp[prevIndex][0] + 1;
                    prev[currentIndex][1] = prevIndex;
                }
            }
            if (dp[currentIndex][0] > maxResult) {
                maxResult = dp[currentIndex][0];
                maxIndexRow = currentIndex;
                maxIndexCol = 0;
            }
            if (dp[currentIndex][1] > maxResult) {
                maxResult = dp[currentIndex][1];
                maxIndexRow = currentIndex;
                maxIndexCol = 1;
            }

        }

        ArrayList<Integer> result = new ArrayList<>();

        while (maxIndexRow >= 0) {
            result.add(input[maxIndexRow]);

            maxIndexRow = prev[maxIndexRow][maxIndexCol];

            if (maxIndexCol == 1) {
                maxIndexCol = 0;
            } else {
                maxIndexCol = 1;
            }
        }

        Collections.reverse(result);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
