import java.util.*;
import java.util.stream.Collectors;

public class CitiesByContinentAndCountry {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, List<String>>> ccc = new LinkedHashMap<>();

        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();

            String[] tokens = input.split(" ");
            String continent = tokens[0];
            String county = tokens[1];
            String city = tokens[2];

            ccc.putIfAbsent(continent, new LinkedHashMap<>());
            ccc.get(continent).putIfAbsent(county, new ArrayList<>());
            ccc.get(continent).get(county).add(city);       //ibah go az tuk //24.08.19 02:11

        }

        // ccc = sortByKeys(ccc);
        ccc.forEach((continentName, countryAndCity) -> {
            System.out.println(continentName + ":");

            countryAndCity.forEach((countryName, cityName) -> {
                System.out.print("  " + countryName + " -> ");

                System.out.println(cityName.stream()
                        .collect(Collectors.joining(", ")));  //love stackoverflow
            });

        });
    }


}
