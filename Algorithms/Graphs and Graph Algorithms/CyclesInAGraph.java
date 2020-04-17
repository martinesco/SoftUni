import java.util.*;

public class CyclesInAGraph {

    private static Map<String, List<String>> graph = new HashMap<>();
    private static HashSet<String> visited = new HashSet<>();
    private static HashSet<String> currentVisited = new HashSet<>();
    private static boolean haveCycle;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }

            String[] edge = line.split("–");

            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }

            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);


        }


        graph.forEach((key, value) -> {
            {
                CheckForCycle(key, null);
            }
        });

        String result = haveCycle ? "No" : "Yes";
        System.out.println("Acyclic: " + result);

    }

    private static void CheckForCycle(String vertex, String parent) {

        if (currentVisited.contains(vertex)) {
            haveCycle = true;
            return;
        }

        if (visited.contains(vertex) || haveCycle) {
            return;
        }

        visited.add(vertex);
        currentVisited.add(vertex);

        for (String child : graph.get(vertex)){
            if (!Objects.equals(child, parent)){
                CheckForCycle(child,vertex);
            }
        }

        currentVisited.remove(vertex);

    }
}
