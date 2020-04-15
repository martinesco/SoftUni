import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop2 {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String,Double>> shopAndProducts = new TreeMap<>();
        String input = scanner.nextLine();

        while (!"Revision".equals(input)){

            String [] tokens = input.split(", ");

            String shopName = tokens[0];
            String productName = tokens[1];
            double productPrice = Double.parseDouble(tokens[2]);

            shopAndProducts.putIfAbsent(shopName,new LinkedHashMap<>());
            shopAndProducts.get(shopName).putIfAbsent(productName,productPrice);

            input = scanner.nextLine();
        }

        shopAndProducts.forEach((shopName,products) ->{
            System.out.println(shopName + "->");
            products.forEach((productName,productPrice) ->{
                System.out.println(String.format("Product: %s, Price: %.1f",
                        productName,
                        productPrice));
            });
        });

    }
}
