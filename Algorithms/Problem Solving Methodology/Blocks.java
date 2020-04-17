import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Blocks {

    private static Set<String> UsedCombinations = new TreeSet<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<String> results = FindBlocks(n);

        PrintBlocks(results);
    }

    private static void PrintBlocks(Set<String> results) {

        System.out.println("Number of blocks: " + results.size() );

        for (String combination : results){
            System.out.println(combination);
        }
    }

    private static TreeSet<String> FindBlocks(int numberOfLetters) {

        char[] letters = new char[numberOfLetters];
        FillLetters(numberOfLetters, letters);

        boolean[] used = new boolean[numberOfLetters];
        char[] currentCombination = new char[4];        //vinagi sa kvadrate 2x2
        TreeSet<String> result = new TreeSet<>();       //dali da ne e Tree

        GenerateVariations(letters, currentCombination, used, result, 0);

        return result;
    }

    private static void GenerateVariations(char[] letters, char[] currentCombination,
                                           boolean[] used, Set<String> result, int index) {

        if (index >= currentCombination.length) {

            AddResult(currentCombination, result);

        } else {

            for (int i = 0; i < letters.length; i++) {

                if (!used[i]) {
                    //  String currentNumber = elements[i];
                    used[i] = true;
                    currentCombination[index] = letters[i];
                    GenerateVariations(letters,
                            currentCombination,
                            used,
                            result,
                            index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void AddResult(char[] result, Set<String> results) {

        String currentCombination = new String(result);

        if (!UsedCombinations.contains(currentCombination)) {
            results.add(currentCombination);

            UsedCombinations.add(currentCombination);

            String a1 = result[3] + "" + result[0] + result[2] + result[1];
            String a2 = result[2] + "" + result[3] + result[1] + result[0];
            String a3 = result[1] + "" + result[2] + result[0] + result[3];

            UsedCombinations.add(a1);
            UsedCombinations.add(a2);
            UsedCombinations.add(a3);

        }

    }

    private static void FillLetters(int numberOfLetters, char[] letters) {

        for (int i = 0; i < numberOfLetters; i++) {
            letters[i] = (char) ('A' + i);
        }
    }

}
