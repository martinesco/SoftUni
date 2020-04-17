import java.util.Scanner;

public class CombinationsWithRepetition {
    static Scanner scanner = new Scanner(System.in);
    static String string = scanner.nextLine();
    static String[] elements = string.split(" ");
    static String[] combinations;

    public static void main(String[] args) {

        int k = Integer.parseInt(scanner.nextLine());
        combinations = new String[k];

        Combinate(0,0);
    }

    private static void Combinate(int index, int start) {
        if (index>=combinations.length){
            for (String toPrint : combinations) {
                System.out.print(toPrint + " ");
            }
            System.out.println();
        }
        else {

            for (int i=start; i<elements.length; i++){

                combinations[index] = elements[i];
                Combinate(index + 1, i); // i+1 pravim na i
            }
        }

    }
    static void swap(int first, int second) {
        String temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }
}
