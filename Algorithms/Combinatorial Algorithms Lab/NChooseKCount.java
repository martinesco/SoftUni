import java.math.BigInteger;
        import java.util.Scanner;

public class NChooseKCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        BigInteger count = CalculateFactorial(n).divide(CalculateFactorial(n - k).multiply(CalculateFactorial(k)) );
        System.out.print(count);
    }

    private static BigInteger CalculateFactorial(int number) {
        BigInteger f = new BigInteger("1");

        for (int i = 2; i <= number; i++) {
            f = f.multiply(BigInteger.valueOf(i));

        }
        return f;
    }
}
