import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Character> stack = new ArrayDeque<>();


        String input = scanner.nextLine();

        boolean areBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '[' || current == '{' || current == '(') {
                stack.push(current);
            } else {

                if (stack.isEmpty()){
                    areBalanced = false;
                    break;
                }

                char topElement = stack.pop();
                if (current == ']' && topElement != '[') {
                    areBalanced = false;
                    break;
                } else if (current == '}' && topElement != '{'){
                    areBalanced = false;
                    break;
                } else if (current == ')' && topElement != '('){
                    areBalanced = false;
                    break;
                }
            }

        }
        if (areBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }

}
