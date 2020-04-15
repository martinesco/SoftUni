import java.util.*;
import java.util.stream.Collectors;

public class ProductShop {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> shopAndProducts = new TreeMap<>();
        String input = scanner.nextLine();

        while (!"Revision".equals(input)){

            String [] tokens = input.split(", ");

            String shopName = tokens[0];
            String productName = tokens[1];
            double productPrice = Double.parseDouble(tokens[2]);

            shopAndProducts.putIfAbsent(shopName,new ArrayList<>());
           // String productAndPrice = "Product: " + product + ", Price: " + price;
            shopAndProducts.get(shopName).add(String.format("Product: %s, Price: %.1f",
                    productName,
                    productPrice));

            input = scanner.nextLine();
        }
        shopAndProducts.forEach((key, value) -> {



                System.out.println(key +
                        "->" +
                        System.lineSeparator() +
                        String.join(System.lineSeparator(),value)

                );
        });
    }
}
