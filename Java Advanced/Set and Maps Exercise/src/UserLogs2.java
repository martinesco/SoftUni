import java.util.*;
import java.util.stream.Collectors;

public class UserLogs2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] tokens = input.split(" ");

            String ip = tokens[0].substring(3);
            String message = tokens[1].substring(8);
            String userName = tokens[2].substring(5);



            if (!users.containsKey(userName)) {
                users.putIfAbsent(userName, new LinkedHashMap<>());
                users.get(userName).putIfAbsent(ip, 1);
               // users.get(userName).get(ip).add(message);
            }
            else {
                if (!users.get(userName).containsKey(ip)){
                    users.get(userName).put(ip, 1);
                   // users.get(userName).put(ip, users.get(userName).get(ip) + 1);
                }
                else {
                    users.get(userName).put(ip, users.get(userName).get(ip) + 1);
                }

            }

            input = scanner.nextLine();
        }

        users.entrySet().forEach(entry ->{
            System.out.println(entry.getKey()+":");


            entry.getValue().entrySet().forEach(innerEntry->{

                System.out.println(String.format("%s => %s.",
                        innerEntry.getKey(),
                        innerEntry.getValue()
                        ));

            });

        });
        /*users.forEach((name, ipAndMessage) ->{
            System.out.println(name + ":");
            users.forEach((ip, timesSent)->{

                System.out.printf("%s => %s,\n", ip, timesSent);
            });


        });*/

    }
}
