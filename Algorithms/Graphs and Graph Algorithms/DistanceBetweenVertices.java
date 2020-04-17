import java.util.*;

public class DistanceBetweenVertices {

    private static Map<Integer, List<Integer>> graph;
    private static Map<Integer, Boolean> visited;
    private static List<int[]> pairs;


    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {


        int vertices = Integer.parseInt(scanner.nextLine());    //vurhove
        int countOfPairs = Integer.parseInt(scanner.nextLine());       //dvoiki

        InitializeGraph(vertices);
        InitializePairs(countOfPairs);

        for (int [] pair : pairs){

            visited = new HashMap<>();

            for (int vertex : graph.keySet()) {
                visited.put(vertex, false);
            }
            int distance = CalculateShortestDistance(pair[0],pair[1]);
            System.out.println(String.format(
                    "{%d, %d} -> %d", pair[0],pair[1],distance
            ));

        }
    }

    private static void InitializePairs(int countOfPairs) {
        pairs = new ArrayList<>();

        for (int i = 0; i < countOfPairs; i++) {
            int[] pair = Arrays.stream(scanner.nextLine().split("-"))
                    .mapToInt(Integer::parseInt).toArray();
            pairs.add(pair);
        }

    }

    private static void InitializeGraph(int vertices) {

        graph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {

            String[] tokens = scanner.nextLine().split(":");

            graph.put((Integer.parseInt(tokens[0])), new ArrayList<>());

            if (tokens.length > 1) {

                int[] asd = Arrays.stream(tokens[1].split(" "))
                        .mapToInt(Integer::parseInt).toArray();

                for (int e : asd) {
                    graph.get((Integer.parseInt(tokens[0]))).add(e);
                }
            }

        }

    }

    private static int CalculateShortestDistance(int source, int destination) {

        ArrayDeque<Integer> vertices = new ArrayDeque<>();
        vertices.offer(source);
        List<Integer> children;
        int distance = 1;

        while (vertices.size() > 0) {
            children = new ArrayList<>();
            while (vertices.size() > 0) {
                int current = vertices.poll();

                for (int child : graph.get(current)) {
                    if (!visited.get(child)) {
                        if (child == destination) {
                            return distance;
                        }
                        visited.put(child, true);
                        children.add(child);
                    }
                }
            }
            vertices = new ArrayDeque<>(children);
            distance++;
        }

        return -1;
    }
}
