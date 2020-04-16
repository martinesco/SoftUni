import java.util.Scanner;

public class FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double nightPrice = Double.parseDouble(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());

        double sum;
        if (nights>7){
             sum = nights*nightPrice*0.95 + budget*percent*0.01;;
        }else {
             sum = nights*nightPrice + budget*percent*0.01;
        }

        if (budget>=sum){
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", budget-sum);
        }
        else {
            System.out.printf("%.2f leva needed.", sum-budget);
        }

    }
}
