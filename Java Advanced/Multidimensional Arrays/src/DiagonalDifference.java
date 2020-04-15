import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];


        for (int i = 0; i < size; i++) {

            String[] line = scanner.nextLine().split(" ");

            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);

            }

        }

        int row = 0, col = 0;
        int primarySum = 0, secondarySum = 0;
        while (row < size && col < size){
            primarySum += matrix[row][col];
            row++;
            col++;
        }


        row--;
        col=0;

        while (row >= 0 && col < size){
            secondarySum += matrix[row][col];
            row--;
            col++;
        }

        System.out.println(Math.abs(primarySum-secondarySum));


    }
}
