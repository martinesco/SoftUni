import java.util.Scanner;

public class NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        int points = 0;
        int bestScore = 0;
        String bestScoreName ="";
        while (!line.equals("Stop")) {

            String name = line;
            for (int i = 0; i < name.length(); i++) {

                int n = Integer.parseInt(scanner.nextLine());

                if (name.charAt(i) == (char) n) {
                    points += 10;
                } else {
                    points += 2;
                }
            }

            if (points >= bestScore) {
                bestScore = points;
                bestScoreName = name;
            }

            points=0;
            line = scanner.nextLine();
        }

        System.out.println("The winner is " + bestScoreName + " with " + bestScore + " points!");

    }
}
