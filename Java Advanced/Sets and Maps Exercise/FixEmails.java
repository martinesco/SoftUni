import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        Map<String,String> contacts = new LinkedHashMap<>();

        String name = scanner.nextLine();

        while (!name.equals("stop")){
            String email = scanner.nextLine();

            if(email.endsWith(".us")
                    || email.endsWith(".com")
                    || email.endsWith(".uk")){
                name=scanner.nextLine();
                continue;
            }

            contacts.put(name,email);

            name=scanner.nextLine();
        }
        contacts.forEach((key,value) ->{
            System.out.printf("%s -> %s\n",key,value);
        });
    }
}
