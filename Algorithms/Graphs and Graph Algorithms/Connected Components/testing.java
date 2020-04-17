import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class testing {

    static List<Integer>[] graph = new List[10];

    static boolean[]visited;

    public static void main(String [] args){
        graph = ReadGraph();
        FindGraphConnectedComponents();

    }

    private static List<Integer>[] ReadGraph(){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();

            String line = scanner.nextLine();

            if (line.equals("")){
                continue;
            }

            int [] asd = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int i1 : asd) {
                graph[i].add(i1);
            }

        }
        return graph;
    }

    private static void FindGraphConnectedComponents(){
        visited = new boolean[graph.length];

        for (int startNode = 0; startNode < graph.length; startNode++) {
            if (!visited[startNode]){
                System.out.print("Connected component:");
                DFS(startNode);
                System.out.println();
            }
        }
    }

    private static void DFS(int vertex) {

        if (!visited[vertex]){
            visited[vertex] = true;

            if (!graph[vertex].isEmpty()) {


                for (int child : graph[vertex]) {
                    DFS(child);
                }
            }
                System.out.print(" " + vertex);

        }
    }

}
