
import java.util.Scanner;

public class FillTheMatrix {


    static int number = 1;
    static int reverse = 1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(", ");

        switch (input[1]){
            case "A" : caseA(Integer.parseInt(input[0])); break;
            case "B" : caseB(Integer.parseInt(input[0])); break;
        }

    }

    static void caseA(int size) {
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                matrix[j][i] = number;
                number++;
            }
        }
        for (int[] ints : matrix) {
            for (int anInt : ints){
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static void caseB(int size) {

        int[][] matrix = new int[size][size];


        for (int i = 0; i < size; i++) {
            if (reverse % 2 == 1) {
                for (int j = 0; j < size; j++) {

                    matrix[j][i] = number;
                    number++;
                }
            } else {
                for (int j = size - 1; j >= 0; j--) {

                    matrix[j][i] = number;
                    number++;
                }
            }
            reverse++;
        }
        for (int[] ints : matrix) {
            for (int anInt : ints){
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
