import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> characters = new TreeMap<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (!characters.containsKey(symbol)) {
                characters.put(symbol, 1);
            } else {
                characters.put(symbol, characters.get(symbol) + 1);
            }


        }

        characters.forEach((key, value) -> {
            System.out.printf("%s: %d time/s\n"
                    , key
                    , value);

        });

    }
}

