import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {

    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);

        Set<String> usernames = new LinkedHashSet<>();

        int numbers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers; i++) {

            String name = scanner.nextLine();
            usernames.add(name);
        }

        for(String str : usernames){
            System.out.println(str);
        }

    }
}
