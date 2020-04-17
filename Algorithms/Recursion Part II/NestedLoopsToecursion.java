import java.util.Scanner;

public class NestedLoopsToecursion {

    static void Recursion(int[] set, int[] array, int index){

        if (index >= array.length) {
            for (int i=0; i<array.length; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();       //!!!
        }
        else
            for (int i=0; i < set.length ; i++) {
                array[index] = set[i];
                Recursion(set, array, index + 1); //mn vajen e bordero
            }
    }
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
       /* String string = scanner.nextLine();
        String[] stringArrays = string.split(" ");
        int[] intArray = new int[stringArrays.length];  // N ot SET
        for (int i=0; i<stringArrays.length ; i++){
            String numberAsString = stringArrays[i];
            intArray[i] = Integer.parseInt(numberAsString);
            // System.out.println("Edno " + intArray[i]);
        }*/
        int n = Integer.parseInt(scanner.nextLine());
        int[] intArray = new int[n];
        for (int i=0; i<n ; i++){
            intArray[i] = i+1;
        }
        int [] k = new int[n];

        Recursion(intArray, k, 0);

    }
}
