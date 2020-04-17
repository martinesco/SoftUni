import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ZigZagMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(","))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int[][] maxPath = new int[rows][cols];
        int[][] previousRowIndex = new int[rows][cols];

        for (int row = 1; row < rows; row++) {
            maxPath[row][0] = matrix[row][0];
        }

        for (int col = 1; col < cols; col++) {

            for (int row = 0; row < rows; row++) {

                int previousMax = 0;

                if (col % 2 != 0) {

                    for (int i = row + 1; i < rows; i++) {

                        if (maxPath[i][col - 1] > previousMax) {

                            previousMax = maxPath[i][col - 1];
                            previousRowIndex[row][col] = i;
                        }

                    }
                } else {
                    for (int i = 0; i < row; i++) {
                        if (maxPath[i][col - 1] > previousMax) {
                            previousMax = maxPath[i][col - 1];
                            previousRowIndex[row][col] = i;
                        }
                    }
                }

                maxPath[row][col] = previousMax + matrix[row][col];
            }
        }

        int currentRowIndex = GetLastRowIndexOfPath(maxPath, cols);

        ArrayList<Integer> path = RecoverMaxPath(cols, matrix, currentRowIndex, previousRowIndex);

        int sum = path.stream().mapToInt(Integer::intValue).sum();
        System.out.print(sum + " = ");
        String asd = path.stream()
                .map(String::valueOf)
                .collect(Collectors
                        .joining(" + "));
        System.out.println(asd);

    }

    private static ArrayList<Integer> RecoverMaxPath(int cols, int[][] matrix, int currentRowIndex, int[][] previousRowIndex) {

        ArrayList<Integer> path = new ArrayList<>();
        int columnIndex = cols - 1;

        while (columnIndex >= 0) {
            path.add(matrix[currentRowIndex][columnIndex]);
            currentRowIndex = previousRowIndex[currentRowIndex][columnIndex];

            columnIndex--;
        }
        Collections.reverse(path);
        return path;
    }

    private static int GetLastRowIndexOfPath(int[][] maxPath, int numberOfColums) {

        int currentRowIndex = -1;
        int globalMax = 0;
        for (int row = 0; row < maxPath.length; row++) {

            if (maxPath[row][numberOfColums - 1] > globalMax) {
                globalMax = maxPath[row][numberOfColums - 1];
                currentRowIndex = row;
            }
        }

        return currentRowIndex;
    }
}
