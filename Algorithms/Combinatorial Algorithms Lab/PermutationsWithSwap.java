import java.util.Scanner;

public class PermutationsWithSwap {

    static int[] elements;

    public static void main(String[] args){

        elements = new int[]{1, 2, 3, 4};
        Permutate(0);
    }
    private static void Permutate(int index) {
        if (index >= elements.length) {
            for (int toPrint : elements) {
                System.out.print(toPrint + " ");
            }
            System.out.println();
        } else {
            Permutate(index + 1);
            for (int i = index + 1; i < elements.length; i++) {
                swap(index, i);
                Permutate(index + 1);
                swap(index, i);

            }
        }
    }
        static void swap(int first, int second){
        int temp = elements[first];
        elements[first] = elements[second];
        elements[second]=temp;

        }

    }
