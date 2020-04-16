import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drink = scanner.nextLine();
        String sugar = scanner.nextLine();
        int drinksNumber = Integer.parseInt(scanner.nextLine());

        double drinkPrice;
        if (drink.equals("Espresso")) {
            if (sugar.equals("Without")) {
                drinkPrice = 0.9;
            } else if (sugar.equals("Normal")) {
                drinkPrice = 1.0;
            } else drinkPrice = 1.2;
        } else if (drink.equals("Cappuccino")) {
            if (sugar.equals("Without")) {
                drinkPrice = 1.0;
            } else if (sugar.equals("Normal")) {
                drinkPrice = 1.2;
            } else drinkPrice = 1.6;
        } else {
            if (sugar.equals("Without")) {
                drinkPrice = 0.5;
            } else if (sugar.equals("Normal")) {
                drinkPrice = 0.6;
            } else drinkPrice = 0.7;
        }

        double sum = drinkPrice * drinksNumber;


        if (sugar.equals("Without")) {
            sum = sum * 0.65;
        }
        if (drink.equals("Espresso") && drinksNumber >= 5) {
            sum = sum * 0.75;
        }
        if (sum>15.0){
            sum = sum*0.8;
        }


        System.out.printf("You bought %d cups of %s for %.2f lv.",
                drinksNumber,drink,sum);
    }
}
