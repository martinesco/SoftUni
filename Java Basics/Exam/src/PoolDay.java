import java.util.Scanner;

public class PoolDay {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int peopleNumber = Integer.parseInt(scanner.nextLine());
        double entryFee = Double.parseDouble(scanner.nextLine());
        double sunbedPrice = Double.parseDouble(scanner.nextLine());
        double umbrellaPrice = Double.parseDouble(scanner.nextLine());

        double umbrellaSum = Math.ceil(peopleNumber / 2.0) * umbrellaPrice;
        double sunbedSum = Math.ceil(peopleNumber * 0.75) * sunbedPrice;


        double sum = peopleNumber * entryFee + umbrellaSum + sunbedSum;
        System.out.printf("%.2f lv.", sum);


    }

}
