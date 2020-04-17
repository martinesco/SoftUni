import java.util.Arrays;
import java.util.Scanner;

public class DividingPresents {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] values = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();


        int totalSum = Arrays.stream(values).sum();

        int[] sums = new int[totalSum + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = -1;
        }

        for (int presIndex = 0; presIndex < values.length; presIndex++) {

            for (int prevSumIndex = totalSum - values[presIndex]; prevSumIndex >= 0; prevSumIndex--) {

                int presentValue = values[presIndex];

                if (sums[prevSumIndex] != -1 &&
                        sums[prevSumIndex + presentValue] == -1) {

                    sums[prevSumIndex + presentValue] = presIndex;
                }
            }
        }
        int half = totalSum / 2;

        for (int i = half; i >= 0; i--) {
            if (sums[i] == -1) {
                continue;
            }

            int toPrint = totalSum - i - i;
            System.out.println("Difference: " + toPrint);
            System.out.println("Alan:" + i + " " + "Bob:" + (totalSum - i));
            System.out.print("Alan takes: ");
            while (i!=0){
                System.out.print(values[sums[i]] + " ");
                i -= values[sums[i]];
            }
            System.out.println();
            System.out.println("Bob takes the rest.");
        }
    }
}
