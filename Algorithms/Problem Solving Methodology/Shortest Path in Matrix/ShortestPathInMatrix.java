import java.util.*;


public class ShortestPathInMatrix {

    private static Scanner scanner = new Scanner(System.in);
    private static int numbersOfRows = Integer.parseInt(scanner.nextLine());
    private static int numbersOfCols = Integer.parseInt(scanner.nextLine());

    private static int[][] matrix;

    public static void main(String[] args) {


        matrix = new int[numbersOfRows][];

        FillMatrix(matrix, numbersOfRows);

        List<Integer> result = DijkstraAlgorithm(matrix, 0, 0, numbersOfRows - 1, numbersOfCols - 1);

        int sum = result.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Length: " + sum);

        System.out.print("Path: ");
        result.forEach(integer -> {{

            System.out.print(integer + " ");

        }
        });

    }

    private static List<Integer> DijkstraAlgorithm(int[][] graph, int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {

        int[][] distance = new int[numbersOfRows][numbersOfCols];

        for (int i = 0; i < numbersOfRows; i++) {
            for (int j = 0; j < numbersOfCols; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[sourceRow][sourceColumn] = 0;

        Doku[][] previous = new Doku[numbersOfRows][numbersOfCols];
        Doku currentCell = new Doku(sourceRow, sourceColumn);
        previous[0][0] = currentCell;
        boolean[][] used = new boolean[numbersOfRows][numbersOfCols];

        Doku[] neighbourCells = new Doku[]{
                new Doku(0, 1),
                new Doku(1, 0),
                new Doku(-1, 0),
                new Doku(0, -1)
        };

        while (true) {

            int minDistance = Integer.MAX_VALUE;

            Doku nextCell = null;

            for (int row = 0; row < numbersOfRows; row++) {

                for (int column = 0; column < numbersOfCols; column++) {

                    if (!used[row][column] && distance[row][column] < minDistance) {

                        minDistance = distance[row][column];
                        nextCell = new Doku(row, column);
                    }
                }
            }

            if (minDistance == Integer.MAX_VALUE) {
                break;
            }


            used[nextCell.getRow()][nextCell.getCol()] = true;

            for (Doku cell : neighbourCells) {

                int row = nextCell.getRow() + cell.getRow();
                int column = nextCell.getCol() + cell.getCol();

                if (row >= 0 && row < numbersOfRows
                        && column >= 0 && column < numbersOfCols) {

                    int newDistance = distance[nextCell.getRow()][nextCell.getCol()] + graph[row][column];

                    if (newDistance < distance[row][column]) {

                        distance[row][column] = newDistance;
                        previous[row][column] = nextCell;
                    }
                }
            }
        }

        if (distance[destinationRow][destinationColumn] == Integer.MAX_VALUE) {
            return null;
        }

        List<Integer> path = new ArrayList<>();
        path.add(graph[destinationRow][destinationColumn]);

        Doku currentNode = previous[destinationRow][destinationColumn];
        while (currentNode.getRow() != 0 || currentNode.getCol() != 0) {
            path.add(graph[currentNode.getRow()][currentNode.getCol()]);
            currentNode = previous[currentNode.getRow()][currentNode.getCol()];
        }

        path.add(graph[sourceRow][sourceColumn]);

        Collections.reverse(path);

        return path;

    }


    private static void FillMatrix(int[][] matrix, int numbersOfRows) {

        for (int i = 0; i < numbersOfRows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

    }
}
