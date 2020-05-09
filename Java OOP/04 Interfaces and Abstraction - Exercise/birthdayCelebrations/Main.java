package birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("End")) {

            String[] tokens = line.split(" ");

            if (tokens.length == 3) {
                if (tokens[0].equals("Pet")) {
                    Birthable pet = new Pet(tokens[1], tokens[2]);
                    birthables.add(pet);
                } /*else {
                    Machine robot = new Robot(tokens[2], tokens[1]);
                }*/

            } else {
                Birthable citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                birthables.add(citizen);
            }


            line = scanner.nextLine();
        }

        String year = scanner.nextLine();

        for (Birthable person : birthables){
            if (person.getBirthDate().endsWith(year)){
                System.out.println(person.getBirthDate());
            }
        }

    }

}
