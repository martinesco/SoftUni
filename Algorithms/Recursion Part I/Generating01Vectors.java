import java.util.Scanner;

public class Generating01Vectors {

    static void Generate(int index, int[] array){

        if (index >= array.length) {
            for (int i=0; i<array.length; i++){
                System.out.print(array[i]);
            }
            System.out.println();       //!!!
        }
        else {
            for (int i=0; i <= 1;i++ ){
                array[index] = i;
                Generate(index + 1, array);
            }
        }
    }
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int [] arr = new int[size];
        Generate(0, arr );
    }

}


