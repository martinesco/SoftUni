import java.util.ArrayList;
import java.util.Scanner;


public class Knapsack01 {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int maxCapacity = Integer.parseInt(scanner.nextLine());
        ArrayList<Item> items  = new ArrayList<Item>();

        while (true){
            String line = scanner.nextLine();

            if (!(line.equals("end"))){

                String [] parts = line.split(" ");

                 Item it = new Item("g",4,2);
                 items.add(new Item(
                        parts[0],
                        Integer.parseInt(parts[2]),
                         Integer.parseInt(parts[1])
                    ));

            }
            else {
                break;
                }
            }

            int [][] prices = new int[items.size() + 1][maxCapacity + 1];
            boolean [][]itemsIncluded = new boolean[items.size() + 1][maxCapacity + 1];

            for (int itemIndex = 0; itemIndex < items.size(); itemIndex++){

                Item item = items.get(itemIndex);
                int rowIndex = itemIndex + 1;

                for (int capacity = 0; capacity<= maxCapacity; capacity++){
                    if (item.weight > capacity){
                        continue;
                    }
                    int excluding = prices[rowIndex - 1][capacity];
                    int including = item.price + prices[rowIndex-1][capacity-item.weight];

                    if (including>excluding){
                        prices[rowIndex][capacity] = including;
                        itemsIncluded[rowIndex][capacity] = true;
                    }
                    else {
                        prices[rowIndex][capacity] = excluding;
                    }
            }
        }

        /*System.out.println(prices[items.size()][maxCapacity]);*/

        ArrayList<Item> result = new ArrayList<>();
        int capacity = maxCapacity;
     //   int itemIndex = items.size() - 1;

        for (int itemIndex = items.size() - 1; itemIndex >= 0; itemIndex--){

            if (capacity == 0){
                break;
            }

            if (itemsIncluded[itemIndex+1][capacity]){
                Item currentItem = items.get(itemIndex);

                result.add(currentItem);

                capacity -= currentItem.weight;
            }

        }


        int resultWeight = result.stream().mapToInt(Item::getWeight).sum();
        System.out.println("Total Weight: " + resultWeight);

        int resultValue = result.stream().mapToInt(Item::getPrice).sum();
        System.out.println("Total Value: " + resultValue);

        for (int i=result.size() - 1; i>=0; i--){
            System.out.println(result.get(i).name);
        }

        //System.out.println(prices[items.size()][maxCapacity]); //vmesto totalValue
    }
}
