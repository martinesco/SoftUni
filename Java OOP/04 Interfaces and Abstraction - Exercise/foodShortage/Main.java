package foodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Buyer> buyerMap = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split(" ");
            if (tokens.length == 4) {
                Buyer citizen = new Citizen(
                        tokens[0],
                        Integer.parseInt(tokens[1]),
                        tokens[2],
                        tokens[3]
                );

                buyerMap.putIfAbsent(tokens[0], citizen);
            } else {
                Buyer rebel = new Rebel(
                        tokens[0],
                        Integer.parseInt(tokens[1]),
                        tokens[2]
                );

                buyerMap.putIfAbsent(tokens[0], rebel);
            }
        }

        String line = scanner.nextLine();

        while (!line.equals("End")) {

            if (buyerMap.containsKey(line)) {
                buyerMap.get(line).buyFood();
            }

            line = scanner.nextLine();
        }

        int foodSum = buyerMap.values()
                .stream().mapToInt(Buyer::getFood).sum();
        System.out.println(foodSum);
    }
}
