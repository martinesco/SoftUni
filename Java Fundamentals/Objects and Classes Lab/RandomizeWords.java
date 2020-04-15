import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords {

    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);

        List<String> tokens = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        while (!tokens.isEmpty()){
            Random random = new Random();

            int randomIndex = random.nextInt(tokens.size());

            String word = tokens.get(randomIndex);
            System.out.println(word);
            tokens.remove(randomIndex);
        }
    }
}
