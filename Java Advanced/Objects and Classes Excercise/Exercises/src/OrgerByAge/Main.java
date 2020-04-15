package OrgerByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Alien> persons = new ArrayList<>();

        while (!line.equals("End")) {

            String [] data = line.split(" ");

            persons.add(new Alien(data[0],data[1],Integer.parseInt(data[2])));

            line = scanner.nextLine();
        }

        persons.stream()
                .sorted((p1,p2)->Integer.compare(p1.getAge(),p2.getAge()))
                .forEach(alien -> {

                    System.out.println(String.format("%s with ID: %s is %d years old.",
                            alien.getName(),alien.getId(),alien.getAge()
                            ));


                });
    }
}
