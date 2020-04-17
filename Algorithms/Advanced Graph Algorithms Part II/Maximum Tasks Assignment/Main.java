import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine().substring(7));
        int edges = Integer.parseInt(scanner.nextLine().substring(7));

        List<Integer>[] graph = new ArrayList[nodes];

        for (int i = 0; i < edges; i++) {


            int[] tokens = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int node = tokens[0];
            int connection = tokens[1];

            if (graph[node] == null) {
                graph[node] = new ArrayList<>();
            }
            if (graph[connection] == null) {
                graph[connection] = new ArrayList<>();
            }

            graph[node].add(connection);
            graph[connection].add(node);
        }

       /* List<Integer>[] graph = new ArrayList[12];
        graph[0] = new ArrayList<>(Arrays.asList(1, 2, 6, 7, 9));
        graph[1] = new ArrayList<>(Arrays.asList(0, 6));
        graph[2] = new ArrayList<>(Arrays.asList(0, 7));
        graph[3] = new ArrayList<>(Arrays.asList(4));
        graph[4] = new ArrayList<>(Arrays.asList(3, 6, 10));
        graph[5] = new ArrayList<>(Arrays.asList(7));
        graph[6] = new ArrayList<>(Arrays.asList(0, 1, 4, 8, 10, 11));
        graph[7] = new ArrayList<>(Arrays.asList(0, 2, 5, 9));
        graph[8] = new ArrayList<>(Arrays.asList(6, 11));
        graph[9] = new ArrayList<>(Arrays.asList(0, 7));
        graph[10] = new ArrayList<>(Arrays.asList(4, 6));
        graph[11] = new ArrayList<>(Arrays.asList(6, 8));*/

        List<Integer> articulationPoints = FindBiConnectedComponents.findArticulationPoints(graph);
        System.out.println(articulationPoints);
    }
}
