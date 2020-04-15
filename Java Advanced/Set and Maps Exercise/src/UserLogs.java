import java.util.*;
import java.util.stream.Collectors;

public class UserLogs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> users = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] tokens = input.split(" ");

            String ip = tokens[0].substring(3);
            String message = tokens[1].substring(8);
            String userName = tokens[2].substring(5);



            if (!users.containsKey(userName)) {
                users.putIfAbsent(userName, new LinkedHashMap<>());
                users.get(userName).putIfAbsent(ip, new ArrayList<>());
                users.get(userName).get(ip).add(message);
            }
            else {
                if (!users.get(userName).containsKey(ip)){
                    users.get(userName).put(ip, new ArrayList<>());
                    users.get(userName).get(ip).add(message);
                }
                else {
                    users.get(userName).get(ip).add(message);
                }

            }

            input = scanner.nextLine();
        }

        //users.entrySet()

        users.forEach((name, ipAndMessage) ->{

            System.out.println(name + ":");

            ipAndMessage.forEach((ip,message)->{

                System.out.printf("%s => %d\n", ip, message.size());

            });

        });

    }
}
