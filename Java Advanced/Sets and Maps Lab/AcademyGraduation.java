import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentInfo = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {

            String studentName = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());


            studentInfo.putIfAbsent(studentName, new ArrayList<>());
            studentInfo.get(studentName).addAll(grades);

        }
        studentInfo.forEach((name, grades) -> {


            double sum = grades.stream().mapToDouble(e -> e).sum();

            double sum2 = 0;

            for (Double grade : grades){
                sum2 += grade;
            }

            double avg = sum2 / grades.size();
            System.out.println(String.format(
                    "%s is graduated with %s",
                    name,
                    avg)
            );
        });

    }
}
