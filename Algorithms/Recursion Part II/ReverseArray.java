import java.util.Scanner;

public class ReverseArray {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] stringArray = input.split(" ");

        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++){
            String numbersAsString = stringArray[i];
            intArray[i] = Integer.parseInt(numbersAsString);
        }
        Reverse(intArray, intArray.length - 1);
    }

    private static int  Reverse(int [] array, int index) {
        if (index == -1) {
            return 0;
        }

        System.out.print(array[index] + " ");

        return Reverse(array, index - 1);

    }

}
