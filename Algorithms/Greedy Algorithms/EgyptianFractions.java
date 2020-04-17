import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EgyptianFractions {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

            String currItem = scanner.nextLine();
            String[] CZ = currItem.split("/");

            int numerator = Integer.parseInt(CZ[0]); // a
            int denominator = Integer.parseInt(CZ[1]); // b

            if (numerator>denominator) {
                System.out.println("Error (fraction is equal to or greater than 1)");
                return;
            }

            System.out.print(currItem + " = ");
            int index = 2; // 3/7 - 1/2

        List<Integer> result = new ArrayList<>();

            while (numerator != 0){
                int nextNumerator = numerator * index;
                int indexNumerator = denominator;

                int remaining = nextNumerator - indexNumerator; // a * c - b

                if (remaining < 0){
                    index++;
                    continue;
                }

                result.add(index);

                numerator = remaining;
                denominator = denominator * index;
                index++;
            }

            for (int toPrint : result){
                if (toPrint == result.get(result.size() - 1)){
                    System.out.print(1 + "/" +toPrint);
                    return;
                }
                System.out.print(1 + "/" + toPrint + " + ");
            }


    }
}
