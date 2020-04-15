import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> elements = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(elements::push);
        //      pulniqt variant na izpisvane e
        //  .forEach(elem -> elements.push(elem));

        while (elements.size() > 0){
            System.out.print(elements.pop() + " ");
        }

    }
}
