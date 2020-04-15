import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class puskaiSrubete {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> concerts = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] check = input.split(" ");
            if (check.length < 4) {
                input = scanner.nextLine();
                continue;
            }

            String srubinName = input.substring(0, input.indexOf("@") - 1);

            String[] tokens = input.substring(input.indexOf("@") + 1).split(" ");//

            /*if (tokens.length < 3) {
                input = scanner.nextLine();
                continue;
            }//TODO da go imislq po umno*/

            int ticketsCount = Integer.parseInt(tokens[tokens.length - 1]);
            int ticketsPrice = Integer.parseInt(tokens[tokens.length - 2]);

            String venue = "";
            if (tokens.length == 3) {
                venue = tokens[0];
            } else {
                venue = input.substring(input.indexOf("@") + 1,
                        input.length() - tokens[tokens.length - 1].length()
                                - tokens[tokens.length - 2].length() - 2);        //-2 ? ima space nakraq
            }
            /*String venue = input.substring(input.indexOf("@") + 1,
                    input.indexOf(tokens[tokens.length - 2]));*/


            if (!concerts.containsKey(venue)) {
                concerts.put(venue, new LinkedHashMap<String, Integer>() {{
                    put(srubinName, ticketsCount * ticketsPrice);
                }});
            } else {
                if (!concerts.get(venue).containsKey(srubinName)) {
                    concerts.get(venue).put(srubinName, ticketsCount * ticketsPrice);
                } else {
                    concerts.get(venue).put(srubinName,
                            concerts.get(venue).get(srubinName) + ticketsCount * ticketsPrice);
                }
            }

            input = scanner.nextLine();
        }


        concerts.entrySet().forEach(entry -> {
            {
                Map<String, Integer> map = new LinkedHashMap<>();

                System.out.println(entry.getKey());

                entry.getValue().entrySet().forEach(innerEntry -> {
                    {
                        map.put(innerEntry.getKey(), innerEntry.getValue());

                    }
                });
                Map<String, Integer> sortedMapDesc = sortByValue(map, false);
                sortedMapDesc.forEach((key, value) -> {

                    System.out.println(String.format("#  %s -> %d",
                            key,
                            value
                    ));

                });

            }
        });


        System.out.println();
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap, final boolean order) {
        List<Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }
}
