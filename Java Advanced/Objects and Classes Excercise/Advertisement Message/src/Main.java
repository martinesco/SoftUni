import java.util.*;

public class Main {

    public static void main(String[]args) {

        List<String> phrases = new ArrayList<>(Arrays.asList("Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."));
        List<String> events = new ArrayList<>(Arrays.asList("Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"));
        List<String> authors = new ArrayList<>(Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"));
        List<String> cities = new ArrayList<>(Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"));

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-->0){

            Random random = new Random();

            int randomIndex1 = random.nextInt(phrases.size());
            int randomIndex2 = random.nextInt(events.size());
            int randomIndex3 = random.nextInt(authors.size());
            int randomIndex4 = random.nextInt(cities.size());

            System.out.println(String.format("%s %s %s - %s",
                    phrases.get(randomIndex1),
                    events.get(randomIndex2),
                    authors.get(randomIndex3),
                    cities.get(randomIndex4)
                    ));

        }
    }
}
