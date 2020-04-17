import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class StronglyConnectedComponents {

    private static List<List<Integer>> stronglyConnectedComponents;
    private static List<Integer>[] graph;
    private static List<Integer>[] reversedGraph;

    private static ArrayDeque<Integer> stack = new ArrayDeque<>();
    private static boolean[] visited;


    public static List<List<Integer>>
    findStronglyConnectedComponents(List<Integer>[] targetGraph) {

        graph = targetGraph;

        visited = new boolean[graph.length];

        BuildReverseGraph();

        for (int node = 0; node < graph.length; node++) {
            if (!visited[node]){
                Dfs(node);
            }
        }
        stronglyConnectedComponents = new ArrayList<List<Integer>>();

        visited = new boolean[graph.length];    //zanulqvame

        while (stack.size() > 0){       //mayoneza
            int node = stack.pop();

            if (!visited[node]){
                stronglyConnectedComponents.add(new ArrayList<>());
                ReverseDfs(node);
            }

        }

        return stronglyConnectedComponents;
    }

    private static void ReverseDfs(int node){
        if (!visited[node]){
            visited[node]=true;

            stronglyConnectedComponents
                    .get(stronglyConnectedComponents.size() - 1).add(node); //poslednio

            for (int child : reversedGraph[node]){
                ReverseDfs(child);
            }

        }
    }

    private static void BuildReverseGraph(){

        reversedGraph = new ArrayList[graph.length];

        for (int node = 0; node < reversedGraph.length; node++) {
            reversedGraph[node] = new ArrayList<>();
        }

        for (int node = 0; node < graph.length; node++) {
            for(int child : graph[node]){
                reversedGraph[child].add(node);
            }
        }


    }

    private static void Dfs(int node){
        if (!visited[node]){
            visited[node] = true;

            for(int child : graph[node]){
                Dfs(child);
            }

            stack.push(node);
        }
    }
}
