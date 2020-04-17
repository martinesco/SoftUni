import java.util.Scanner;

public class CombinationsWithRepetition {

    static void GenerateCombinations(int[] set, int[] array, int index, int border) {

        if (index >= array.length) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();       //!!!!!!!!!!!!!!!
        } else
            for (int i = border; i < set.length; i++) {
                array[index] = set[i];
                GenerateCombinations(set, array, index + 1, i + 1 ); //border!!!
            }  //i + 1 ==bez povtorenie //i = s povtorenie
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
        }
        int combinations = scanner.nextInt();// K or array
        int[] k = new int[combinations];
        GenerateCombinations(input, k, 0, 0);

    }
}
