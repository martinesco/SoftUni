import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {

            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            double mark = Double.parseDouble(tokens[1]);

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(mark);

        }
        students.forEach((kkk, vvv) -> {
            String allGrades = vvv.stream()
                    .map(g -> String.format("%.2f", g))
                    .collect(Collectors.joining(" "));

            double avg = vvv.stream().mapToDouble(e -> e).average().orElse(0d);

            System.out.println(
                    String.format("%s -> %s (avg: %.2f)",
                            kkk, allGrades, avg));
        });
    }
}
