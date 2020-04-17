import java.util.Scanner;

public class RecursiveArraySum {

    static int Sum(int[] arr, int index){
        if (index ==arr.length) {return 0;}
        return arr[index] + Sum(arr, index +1);
    }

    public static void main (String [] args){

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] stringArray = string.split(" ");

        int[] intArray = new int[stringArray.length];
        for (int i=0; i<stringArray.length;i++){
            String numberAsString = stringArray[i];
            intArray[i] = Integer.parseInt(numberAsString);
        }
        int sum = Sum(intArray,0);
        System.out.println(sum);
        //System.out.println("Vtori nachin " + Sum(intArray,0));

//        int [] numbers = {1,2,3,4,5};
//        int sum = Sum(numbers,0);
//        System.out.println(sum);
    }
}
