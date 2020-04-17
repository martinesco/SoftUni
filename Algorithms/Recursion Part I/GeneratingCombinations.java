import java.util.Scanner;

public class GeneratingCombinations {

    static void Recurss(int[] set, int[] array, int index, int border){

        if (index >= array.length) {
            for (int i=0; i<array.length; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();       //!!!!!!!!!!!!!!!
        }
        else
            for (int i = border; i < set.length ; i++) {
            array[index] = set[i];
            Recurss(set, array, index + 1, i + 1 ); //mn vajen e bordero
            }
    }
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] intArray = new int[n];
        for (int i=0; i<n ; i++){
            intArray[i] = i+1;
        }

    }
}
