import java.util.ArrayList;
import java.util.List;

public class KruskalAlgorithm {

    public static List<Edge> kruskal(int numberOfVertices, List<Edge> edges) {


        List<Edge> spanningTree = new ArrayList<Edge>();
        edges.sort(Edge::compareTo);         // ?

        int[] parent = new int[numberOfVertices];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (Edge edge : edges) {

            int rootStartNode = findRoot(edge.getStartNode(), parent);
            int rootEndNode = findRoot(edge.getEndNode(), parent);

            if (rootStartNode != rootEndNode){
                spanningTree.add(edge);
                parent[rootEndNode] = rootStartNode;
            }

        }
        return spanningTree;
    }

    public static int findRoot(int node, int[] parent) {

        int root = node;
        while (parent[root] != root){
            root=parent[root];
        }

        while (node!=root){
            int previousParent = parent[node];
            parent[node]=root;
            node= previousParent;
        }

        return root;
    }
}
