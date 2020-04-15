import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        while (true) {

            String input = scanner.nextLine();
            if (input.equals("END")) {
                return;
            } else {
                String[] tokens = input.split(" ");
                if (tokens[0].equals("swap") && tokens.length==5) { //DEBA TAQ PROVERKA da e ==5

                    int firstRow = Integer.parseInt(tokens[1]);
                    int firstCol = Integer.parseInt(tokens[2]);
                    int secondRow = Integer.parseInt(tokens[3]);
                    int secondCol = Integer.parseInt(tokens[4]);
                    if (isInBounds(matrix, firstRow, firstCol) &&
                            isInBounds(matrix, secondRow, secondCol)) {

                        String temp = matrix[firstRow][firstCol];
                        matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                        matrix[secondRow][secondCol] = temp;
                        printMatrix(matrix, rows, cols);
                    } else {
                        System.out.println("Invalid input!");
                    }
                }else {
                    System.out.println("Invalid input!");
                }
            }
        }
    }

    private static boolean isInBounds(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static void swap(String first, String second) {
        String temp = first;
        first = second;
        second = temp;
    }
}
