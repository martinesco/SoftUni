import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0){

            int [] tokens = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            if (tokens.length>1){
                stack.push(tokens[1]);
            }
            else {
                if (tokens[0]==2){ //delete
                    stack.pop();
                }
                else {
                    System.out.println(Collections.max(stack));
                }
            }

        }
    }
}
