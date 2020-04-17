public class Combinations {


    static int k = 3;
    static int n = 5;
    static int [] arr = new int[k];

    public static void main (String[] args){
        Comb(0,0);

    }
    static void Comb(int index, int start) {
        if (index >= k) {
            for(int toPrint : arr){
                System.out.print(toPrint + " ");
            }
            System.out.println();

        }
        else {
            for (int i = start; i < n; i++) {
                arr[index] = i;
                Comb(index+1, i + 1);
            }
        }
    }

}
