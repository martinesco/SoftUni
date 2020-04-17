import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class TowersOfHanoi {

    private static final int discs = 8;

    static Stack<Integer> firstTower = new Stack<Integer>();
    static Stack<Integer> secondTower = new Stack<Integer>();
    static Stack<Integer> thirdTower = new Stack<Integer>();

    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());

        System.out.print("Source: ");
        for ( ; i>=1 ;i--){
            firstTower.add(i);
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Destination:");
        System.out.println("Spare:");
    }

    static void Solve(int index){
        if (firstTower.isEmpty()){
            return;
        }
        else while (firstTower.firstElement() != firstTower.lastElement()){

            if (CanMoveDisc(index)){
                MoveUpperDisc(index);
                Solve(index - 1);
            }
        }
    }

    private static boolean CanMoveDisc(int n) {
        if (secondTower.firstElement() < n){
            return false;
        }
        if (thirdTower.firstElement() < n){
            return false;
        }
        return true;
    }

    private static void MoveUpperDisc(int n) {
        secondTower.push(n);

    }

}
