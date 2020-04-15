import java.util.*;

public class PeriodicTable {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        Set<String> elements = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        

        while (n-- > 0){

            String [] input = scanner.nextLine().split(" ");

            elements.addAll(Arrays.asList(input));
            
            
        }

        elements.forEach(e -> System.out.print(e + " "));
    }
}
