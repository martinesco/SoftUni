import java.util.*;

public class SetsOfElements {

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();

        String [] tokens = scanner.nextLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        for (int i = 0; i < n+m; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (i < n){
                first.add(number);
            }
            else {
                second.add(number);
            }

        }

        first.retainAll(second);
        for (Integer integer : first) {
            System.out.print(integer + " ");
        }

    }
}
