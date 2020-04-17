import java.util.*;

public class AreasInMatrix {

    private static String[][] matrix;
    private static boolean[][] visited;
    private static Map<String, Integer> counts;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        matrix = new String[n][];

        for (int i = 0; i < n; i++) {

            matrix[i] = scanner.nextLine().split("");
        }
        int m = matrix[0].length;
        visited = new boolean[n][m];

        counts = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (!visited[i][j]) {

                    if (!counts.containsKey(matrix[i][j])) {
                        counts.put(matrix[i][j], 0);
                    }
                    TraverseMatrix(i, j, matrix[i][j]);

                    counts.put(matrix[i][j], counts.get(matrix[i][j]) + 1);
                }
            }
        }
        int sum = counts.values().stream().reduce(0, Integer::sum);
        System.out.println("Areas: " + sum);

        counts.forEach((letter, zones) -> {
            {

                System.out.println(String.format("Letter '%s' -> %d",
                        letter, zones));
            }
        });

    }
    private static void TraverseMatrix(int i, int j, String letter) {

        if (i >= 0 && i < matrix.length
                && j >= 0 && j < matrix[0].length
                && visited[i][j] == false && matrix[i][j].equals(letter)) {

            visited[i][j] = true;

            TraverseMatrix(i - 1, j, letter);
            TraverseMatrix(i + 1, j, letter);
            TraverseMatrix(i, j - 1, letter);
            TraverseMatrix(i, j + 1, letter);
        }

    }
}

