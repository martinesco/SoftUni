import java.util.Scanner;

public class VariationsWithRepetition   {

    static Scanner scanner = new Scanner(System.in);
    static String string = scanner.nextLine();
    static String[] elements = string.split(" ");
    static String[] variations;

    public static void main(String[] args) {

        int variat = Integer.parseInt(scanner.nextLine());
        variations = new String[variat];

        Variations(0);
    }

    private static void Variations(int index) {
        if (index>=variations.length){
            for (String toPrint : variations) {
                System.out.print(toPrint + " ");
            }
            System.out.println();
        }
        else {
            for (int i=0; i<elements.length; i++){
                    variations[index] = elements[i];
                    Variations(index+1);
            }
        }

    }
    static void swap(int first, int second) {
        String temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }
}
