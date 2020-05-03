package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<String> asd = new ArrayList<>();

        while (!line.equals("End")) {

            String[] tokens = line.split(" ");

            if (tokens.length == 3) {
                asd.add(tokens[2]);
            }
            if (tokens.length == 2) {
                asd.add(tokens[1]);
            }

            line = scanner.nextLine();
        }

        String lastDigits = scanner.nextLine();

        for (String id : asd) {
            if (id.endsWith(lastDigits)) {
                System.out.println(id);
            }
        }

    }
}
