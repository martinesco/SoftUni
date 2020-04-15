import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> text = new ArrayDeque<>();
        String letters = "";

        while (n-- > 0) {

            String[] input = scanner.nextLine().split(" ");
            int command = Integer.parseInt(input[0]);

            switch (command) {
                case 1:
                    text.push(letters);
                    letters += input[1];
                    break;

                case 2:
                    text.push(letters);
                    int number = Integer.parseInt(input[1]);

                    for (int i = 0; i < number; i++) {
                        letters = letters.substring(0, letters.length() - 1);
                    }

                    break;

                case 3:

                    System.out.println(
                            letters.charAt(Integer.parseInt(input[1]) - 1)
                    );

                    break;

                case 4:
                    letters = text.pop();
                    break;
            }

        }
    }
}
