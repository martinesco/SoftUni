import java.util.*;

public class Main {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static ArrayDeque<Integer> connected;

    public static void main(String[] args) {
        graph = readGraph();

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);

        if (connectedComponents.isEmpty()) {
            System.out.println("Connected component:");
        }

        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.print("Connected components: ");
            connectedComponent.forEach(e -> {
                System.out.print(e + " ");
            });
            System.out.println();
        }
    }

    private static List<List<Integer>> readGraph() {
        Scanner in = new Scanner(System.in);

        List<List<Integer>> graph = new ArrayList<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {

            List<Integer> connectedComponents = new ArrayList<>();

            String line = in.nextLine();
            if (line.equals("")) {
                graph.add(connectedComponents);
                continue;
            }
            String[] nodes = line.split(" ");

            for (String node : nodes) {
                connectedComponents.add(Integer.parseInt(node));
            }

            graph.add(connectedComponents);
        }
        return graph;
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {

        visited = new boolean[graph.size()]; // -1 ?
        List<Deque<Integer>> result = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {

                connected = new ArrayDeque<>();
                dfs(i, graph);
                result.add(connected);
            }
        }
        return result;
    }

    private static void dfs(int vertex, List<List<Integer>> graph) {
        if (!visited[vertex]) {
            visited[vertex] = true;

            for (int child : graph.get(vertex)) {
                dfs(child, graph);
            }
            connected.add(vertex);
        }
    }
}
