import java.util.Scanner;

public class Permutations {

   static int[] elements;
   static boolean[] used;
   static int [] permutations;

    public static void main(String[] args){

        elements = new int[]{1, 2, 3, 4};
        used = new boolean[elements.length];
        permutations = new int[elements.length];

        Permutate(0);
    }
    private static void Permutate(int index){
        if (index>= elements.length){
            for (int toPrint : permutations){
                System.out.print(toPrint + " ");
            }
            System.out.println();
        }
        else for (int i=0;i<elements.length;i++){
            if (!used[i]){
                int currentNumber = elements[i];
                used[i]=true;
                permutations[index] = currentNumber;
                Permutate(index+1);
                used[i] = false;
            }
        }

    }
}
