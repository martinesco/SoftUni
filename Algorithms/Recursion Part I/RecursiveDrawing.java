import java.util.Scanner;

public class RecursiveDrawing {

    public static void main(String[] args){

//        int n=5;
//        String s = "*";
//        String repeated = new String(new char[n]).replace("\0", s);
//        System.out.println(repeated);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        repeat(n,0);

    }

    static int  repeat(int n, int index){
        if (n<=index){
            return 0;
        }
        String star = "*";
        String hashtag = "#";

//        System.out.println("Before recursion " + index);
        String repeatStar = new String(new char[n-index]).replace("\0", star);
        System.out.println(repeatStar);

        int Return = repeat(n, index +1);

//        System.out.println("After recursion " +index);
        String repeatHashTag = new String(new char[n-index]).replace("\0", hashtag);
        System.out.println(repeatHashTag);

        return Return;
    }
}
