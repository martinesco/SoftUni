import java.util.HashSet;
import java.util.Scanner;

public class PermutationsWithRepetition {

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

            HashSet<String> used = new HashSet<String>();
            used.add(elements[index]);

            for (int i = index + 1; i < elements.length; i++) {
                if(!used.contains(elements[i])){
                    used.add(elements[i]);

                    swap(index, i);
                    Permutate(index + 1);
                    swap(index, i);
                }
            }
        }
    }
    static void swap(int first, int second) {
        String temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }
}