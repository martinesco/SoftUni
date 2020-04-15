import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //  <type,< <name>  <damage,health,armor> > >
        Map<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split(" ");
            String type = tokens[0];
            String name = tokens[1];
            int damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);
            int armor = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);


            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<String, int[]>(){{
                    put(name, new int[]{damage,health,armor});
                }});
            }else
            {
                if (!dragons.get(type).containsKey(name)){
                    dragons.get(type).put(name,new int[]{damage,health,armor});
                }
                else {
                    dragons.get(type).get(name)[0] = damage;
                    dragons.get(type).get(name)[1] = health;
                    dragons.get(type).get(name)[2] = armor;
                }

            }


        }

        dragons.entrySet().forEach(entry -> {

            double avgDamage = 0;
            double avgHealth = 0;
            double avgArmor = 0;

            double [] aggregatedData = new double[3];

            entry.getValue().entrySet().forEach(innerEntry->{
                double damage = innerEntry.getValue()[0];
                double health = innerEntry.getValue()[1];
                double armor = innerEntry.getValue()[2];

                aggregatedData[0] += damage;
                aggregatedData[1] += health;
                aggregatedData[2] += armor;

            });

            int dragonsCount = entry.getValue().size();

            avgDamage = aggregatedData[0] / dragonsCount;
            avgHealth = aggregatedData[1] / dragonsCount;
            avgArmor = aggregatedData[2] / dragonsCount;

            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)",
                    entry.getKey(),
                    avgDamage,
                    avgHealth,
                    avgArmor));


            entry.getValue().entrySet().stream().forEach(dragon ->{

                System.out.println(String.format(
                        "-%s -> damage: %d, health: %d, armor: %d",
                        dragon.getKey(),
                        dragon.getValue()[0],
                        dragon.getValue()[1],
                        dragon.getValue()[2]
                        ));

            });


        });





    }



}
