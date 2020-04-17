import java.util.Scanner;

public class PermutationsWithoutRepetitions {

    static Scanner scanner = new Scanner(System.in);
    static String string = scanner.nextLine();
    static String[] elements = string.split(" ");

    public static void main(String[] args) {

        Permutate(0);
    }

    private static void Permutate(int index) {
        if (index >= elements.length) {
            for (String toPrint : elements) {
                System.out.print(toPrint + " ");
            }
            System.out.println();
        } else

        {
            Permutate(index + 1);

            for (int i = index + 1; i < elements.length; i++) {

                swap(index, i);
                Permutate(index + 1);
                swap(index, i);
            }
        }
    }

    static void swap(int first, int second) {
        String temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }
}