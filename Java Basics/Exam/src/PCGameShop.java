import java.util.Scanner;

public class PCGameShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sellsNumber = Integer.parseInt(scanner.nextLine());
        int n = (int)sellsNumber;

        double hearthstone = 0;
        double fornite = 0;
        double overwatch = 0;
        double others = 0;


        while (n-- > 0) {

            String name = scanner.nextLine();

            if (name.equals("Hearthstone")) {
                hearthstone++;
            } else if (name.equals("Fornite")) {
                fornite++;
            } else if (name.equals("Overwatch")) {
                overwatch++;
            } else {
                others++;
            }

        }

        System.out.printf("Hearthstone - %.2f%%\n", (hearthstone / sellsNumber)*100);
        System.out.printf("Fornite - %.2f%%\n", (fornite / sellsNumber)*100);
        System.out.printf("Overwatch - %.2f%%\n", (overwatch / sellsNumber)*100);
        System.out.printf("Others - %.2f%%\n", (others / sellsNumber)*100);

    }
}
