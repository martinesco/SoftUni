import java.util.ArrayList;
import java.util.List;

public class ArticulationPoints {

    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int[] depths;
    private static int[] lowPoint;

    private static Integer[] parent;   //nullable int

    private static List<Integer> articulationPoints;

    public static List<Integer> findArticulationPoints(List<Integer>[] targetGraph) {

        graph = targetGraph;
        visited = new boolean[targetGraph.length];
        depths = new int[targetGraph.length];
        lowPoint = new int[targetGraph.length];

        parent = new Integer[targetGraph.length];

        articulationPoints = new ArrayList<>();


        for (int node = 0; node < graph.length; node++) {
            if (!visited[node]){
                FindArticulationPoint(node,1);
            }
        }


        return articulationPoints;
    }

    private static void FindArticulationPoint(int node, int depth) {

        visited[node] = true;
        depths[node] = depth;
        lowPoint[node] = depth;

        int childCount = 0;
        boolean isArticulationPoint = false;

        for (int child : graph[node]) {         //adalietaka
            if (!visited[child]) {

                parent[child] = node;
                FindArticulationPoint(child, depth + 1);
                childCount++;

                if (lowPoint[child] >= depths[node]) {
                    isArticulationPoint = true;
                }

                lowPoint[node] = Math.min(lowPoint[node], lowPoint[child]);

            }
            else
                try {
                    if (child != parent[node]) {

                        lowPoint[node] = Math.min(lowPoint[node], depths[child]);
                    }
                }catch (Exception e){

                }
        }

        if ((parent[node] == null && childCount > 1)
                || (parent[node] != null && isArticulationPoint)) {

            articulationPoints.add(node);
        }
    }
}