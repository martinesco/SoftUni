import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p01_sumOfCoins {

    static Map<Integer, Integer> result = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[coins.length - 1 - i]);
        }
        int targetSum = Integer.parseInt(in.nextLine().substring(5));
        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
        // fancy printing

        int sum = usedCoins.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Number of coins to take: " + sum);

        for (Integer name : usedCoins.keySet()){
            String key = name.toString();
            String value = usedCoins.get(name).toString();                          //tva e genialno//
            System.out.println(value + " coin(s) with value " + key);
        }


    }
    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) throws IllegalStateException {
        int coinIndex = 0;
        int currentSum = 0;
        while (coinIndex < coins.length && currentSum != targetSum) {
            int currentCoinValue = coins[coinIndex];

            if (currentSum + currentCoinValue > targetSum) {
                coinIndex++;
                continue;
            }

            int remainingSum = targetSum - currentSum;
            Integer coinsToTake = remainingSum / currentCoinValue;
            if (coinsToTake > 0) {
                result.put(currentCoinValue, coinsToTake);
                currentSum += coinsToTake * currentCoinValue;
            }
        }
        try {
            if (currentSum != targetSum) {
                throw new IllegalStateException();
            }
        }
        catch (IllegalStateException e){
            System.out.print("Cannot reach desired sum with these coin values");
            System.exit(1);
        }
        return result;
    }
}
