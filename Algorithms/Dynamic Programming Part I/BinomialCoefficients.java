import java.math.BigInteger;
import java.util.Scanner;

public class BinomialCoefficients {


    static int [] numbers = new int[150];
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

            BigInteger answer = (fac(n)).divide((fac(k)).multiply(fac(n-k)));
            System.out.println(answer);

    }
    private static BigInteger fac(int number) {
        BigInteger f = new BigInteger("1");

        for (int i = 2; i <= number; i++) {
            f = f.multiply(BigInteger.valueOf(i));

        }
        return f;
    }
}
