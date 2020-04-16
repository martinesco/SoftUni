import java.util.Scanner;

public class Club {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double profit = Double.parseDouble(scanner.nextLine());

        String line = scanner.nextLine();
        double total = 0.0;

        while (!line.equals("Party!") ) {

            String name = line;
            int number = Integer.parseInt(scanner.nextLine());

            double sum = name.length() * number;

            if (sum % 2 == 1) {
                sum = sum * 0.75;
            }
            total = total + sum;

            if (profit <= total){
                break;
            }
            line = scanner.nextLine();
        }

        if (profit > total) {
            System.out.printf("We need %.2f leva more.\n", profit - total);
        } else {
            System.out.println("Target acquired.");
        }

        System.out.printf("Club income - %.2f leva.", total);
    }
}
