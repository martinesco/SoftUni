package Students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> students = new ArrayList<>();

        while (n-->0){

            String [] tokens = scanner.nextLine().split(" ");
            String par1 = tokens[0];
            String par2 = tokens[1];
            double par3 = Double.parseDouble(tokens[2]);

            students.add(new Student(par1,par2,par3));
        }

        students.stream()
                .sorted((p1,p2)-> Double.compare(p2.getGrade(),p1.getGrade()))
                .forEach(student -> {{

                    System.out.printf("%s %s: %.2f\n",
                            student.getFirstName(),
                            student.getLastName(),
                            student.getGrade());

                }
                });


    }
}
