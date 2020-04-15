import java.util.Scanner;

public class Main {

    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);

        String [] tokens = scanner.nextLine().split(", ");
        Article article = new Article(tokens[0],tokens[1],tokens[2]);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-->0){

            String line = scanner.nextLine();

            String command = line.substring(0, line.indexOf(":"));
            String newThing = line.substring(line.indexOf(":")+2, line.length());//space

            switch (command){
                case "Edit":
                    article.setContent(newThing);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(newThing);
                    break;
                case "Rename":
                    article.setTitle(newThing);
                    break;
            }
        }
        System.out.println(article.toString());
    }
}
