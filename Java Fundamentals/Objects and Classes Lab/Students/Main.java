import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Student> students = new ArrayList<>();

        while (!line.equals("end")){

            String [] tokens = line.split(" ");

            students.add(new Student(tokens[0], tokens[1], tokens[2], tokens[3]));

            line=scanner.nextLine();
        }

        line = scanner.nextLine();

        for (Student student : students){

            if (student.getHometown().equals(line)){

                System.out.println(student.getFirstName() + " "
                + student.getLastName() + " is "
                + student.getAge() + " years old.");
            }
        }
    }
}
