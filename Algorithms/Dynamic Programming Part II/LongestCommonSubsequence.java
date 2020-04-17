import java.util.Objects;
import java.util.Scanner;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.nextLine().split("");
        String[] second = scanner.nextLine().split("");

        int[][] lcs = new int[first.length + 1][second.length + 1];

        for (int row = 1; row <= first.length; row++) {
            for (int col = 1; col <= second.length; col++) {

                int up = lcs[row - 1][col];
                int left = lcs[row][col - 1];

                int result = Math.max(up, left);

                if (Objects.equals(first[row - 1], second[col - 1])) {
                    result = Math.max(1 + lcs[row - 1][col - 1], result);
                }
                lcs[row][col] = result;
            }
        }
        System.out.println(lcs[first.length][second.length]);


    }
}
