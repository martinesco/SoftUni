import java.util.*;

public class SoftUniParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        String input = scanner.nextLine();

        while (! "PARTY".equals(input)) {
            if (input.length() == 8) {
                if (Character.isDigit(input.charAt(0))) {
                    vipGuests.add(input);
                } else {
                    regularGuests.add(input);
                }
            }
            input = scanner.nextLine();
        }
        while (!"END".equals(input = scanner.nextLine())){
            if (Character.isDigit(input.charAt(0))) {
                vipGuests. remove(input);
            } else {
                regularGuests.remove(input);
            }
        }

        System.out.println(vipGuests.size() + regularGuests.size());
        vipGuests.forEach(System.out::println);
        regularGuests.forEach(System.out::println);


    }
}
