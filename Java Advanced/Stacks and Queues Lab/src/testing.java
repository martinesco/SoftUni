import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class testing {



    public static void main (String [] args){

        int [][][] intArray = new int[5][5][5];

        for (int[][] ints : intArray) {
            for (int [] anInt : ints)

            System.out.println(Arrays.toString(anInt));

        }

    }
}
