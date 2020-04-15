import java.util.*;

public class Main {


    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        /*Map<String,Integer> persons = new TreeMap<>();*/
        List<Person> persons = new ArrayList<>();

        while (n-->0){

            String [] tokens = scanner.nextLine().split(" ");
            /*persons.put(tokens[0],Integer.parseInt(tokens[1]));*/

            persons.add(new Person(tokens[0],Integer.parseInt(tokens[1])));

        }

        persons.stream().filter(person -> person.getAge()>30);

       /* persons.entrySet().forEach(entry->{

            if (entry.getValue()>30){
                System.out.println(String.format("%s - %d",
                        entry.getKey(),entry.getValue()));
            }

        });*/
    }
}
