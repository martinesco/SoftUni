import java.math.BigInteger;
        import java.util.Scanner;

public class SumBigNumbers {

    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);

        BigInteger bigInteger = new BigInteger(scanner.nextLine());
        BigInteger bigInteger1 = new BigInteger(scanner.nextLine());

        System.out.println(bigInteger.add(bigInteger1));
    }
}
