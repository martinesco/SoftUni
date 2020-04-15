import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split("_");

            songs.add(new Song(tokens[0], tokens[1], tokens[2]));
        }

        String typeSearch = scanner.nextLine();

        if (typeSearch.equals("all")){
            for (Song song : songs){
                    System.out.println(song.getName());
            }
        }

        for (Song song : songs){
            if (song.getTypeList().equals(typeSearch)){
                System.out.println(song.getName());
            }
        }
    }
}
