import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> logs = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split(" ");
            String ip = tokens[0];
            String name = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            if (!logs.containsKey(name)) {
                logs.put(name, new TreeMap<>());
                logs.get(name).put(ip, duration);
            }else {
                if (!logs.get(name).containsKey(ip)) {
                    logs.get(name).put(ip, duration);
                }
                else {
                    logs.get(name).put(ip, logs.get(name).get(ip) + duration);
                }
            }
        }


        logs.forEach((name,ipAndDuration)->{
            System.out.print(name + ": ");

            System.out.print(ipAndDuration.values().
            stream().mapToInt(e->e).sum());

            System.out.print(" ");

            System.out.println(ipAndDuration.keySet());

        });



    }
}
