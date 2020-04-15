import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("search")) {

            String[] tokens = input.split("-");
            String name = tokens[0];
            String phone = tokens[1];
            phoneBook.put(name, phone);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")){



                if (!phoneBook.containsKey(input)){
                    System.out.printf("Contact %s does not exist.\n", input);
                }
                else {
                    System.out.printf("%s -> %s\n",input,phoneBook.get(input));
                }

            input = scanner.nextLine();
        }


    }
}
