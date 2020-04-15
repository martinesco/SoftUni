/*
import java.util.*;

public class puskaiSrubete2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<Integer, String>> concerts = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] check = input.split(" ");
            if (check.length < 4) {
                input = scanner.nextLine();
                continue;
            }

            String srubinName = input.substring(0, input.indexOf("@") - 1);

            String[] tokens = input.substring(input.indexOf("@") + 1).split(" ");//

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


            if (!concerts.containsKey(venue)) {
                concerts.put(venue, new LinkedHashMap<Integer, String>() {{
                    put(ticketsCount * ticketsPrice, srubinName);
                }});
            } else {
                if (!concerts.get(venue).containsValue(srubinName)) {   //
                    concerts.get(venue).put(ticketsCount * ticketsPrice, srubinName);
                } else {
                    */
/*concerts.get(venue).put(srubinName,
                            concerts.get(venue).get(srubinName) + ticketsCount * ticketsPrice);
*//*

                    concerts.get(venue).values().forEach(val->{{

                        if (srubinName.equals(val)){
                            val.
                        }
                    }
                    });

                }
            }

            input = scanner.nextLine();
        }


        concerts.entrySet().forEach(entry -> {
            {
                System.out.println(entry.getKey());

                concerts.forEach((key, value) -> {

                    System.out.println(String.format("#  %s -> %d",
                            value,
                            key
                    ));

                });

            }
        });

    }


}
*/
