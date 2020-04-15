import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = getPlayerCards(scanner.nextLine());
        Set<Integer> secondPlayer = getPlayerCards(scanner.nextLine());

        for (int round = 0; round < 50; round++) {

            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) break;

            Iterator<Integer> firstPlayerIterator = firstPlayer.iterator();
            Iterator<Integer> secondPlayerIterator = secondPlayer.iterator();

            int firstPlayerValue = firstPlayerIterator.next();
            firstPlayer.remove(firstPlayerValue);
            int secondPlayerValue = secondPlayerIterator.next();
            secondPlayer.remove(secondPlayerValue);

            if (firstPlayerValue > secondPlayerValue) {
                firstPlayer.add(firstPlayerValue);
                firstPlayer.add(secondPlayerValue);
            } else if (firstPlayerValue < secondPlayerValue) {
                secondPlayer.add(firstPlayerValue);
                secondPlayer.add(secondPlayerValue);
            } else {
                firstPlayer.add(firstPlayerValue);
                secondPlayer.add(secondPlayerValue);
            }
        }
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");

        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static LinkedHashSet<Integer> getPlayerCards(String line) {
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(result::add);
        return result;
    }
}
