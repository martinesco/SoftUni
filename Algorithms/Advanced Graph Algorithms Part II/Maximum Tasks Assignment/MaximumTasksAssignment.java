import java.util.*;

public class MaximumTasksAssignment {

    private static int[][] graph;
    private static int[] parents;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int personsCount = Integer.parseInt(scanner.nextLine().substring(9));
        int tasksCount = Integer.parseInt(scanner.nextLine().substring(7));

        int nodes = personsCount + tasksCount + 2;
        graph = new int[nodes][];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new int[nodes];
        }

        for (int i = 0; i < personsCount; i++) {
            graph[0][i + 1] = 1;
        }

        for (int i = 0; i < tasksCount; i++) {

            graph[i + personsCount + 1][graph.length - 1] = 1;
        }

        for (int i = 0; i < personsCount; i++) {

            String[] line = scanner.nextLine().split("");

            for (int j = 0; j < tasksCount; j++) {
                if (line[j].equals("Y")) {
                    graph[i + 1][j + personsCount + 1] = 1;
                }
            }
        }
        FindMaxFlow();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Set<String> result = new TreeSet<>();
        boolean[] visited = new boolean[graph.length];

        int start = 0;
        int end = graph.length - 1;

        queue.offer(end);

        while (queue.size() > 0) {
            int node = queue.poll();
            visited[node] = true;

            for (int i = 0; i < graph.length; i++) {
                if (graph[node][i] > 0 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;

                    if (node != end && node != start && i != end && i != start) {

                        String asd = (char) (node - personsCount - 1 + 'A') + "-" +i;
                        result.add(asd);
                    }
                }
            }
        }
        result.forEach(System.out::println);

    }

    private static void FindMaxFlow() {

        parents = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            parents[i] = -1;
        }

        int maxFlow = 0;
        int start = 0;
        int end = graph.length - 1;

        while (BFS(start, end)) {

            int currentNode = end;

            while (currentNode != start) {
                int previousNode = parents[currentNode];

                graph[previousNode][currentNode] = 0;
                graph[currentNode][previousNode] = 1;

                currentNode = previousNode;
            }
        }

    }

    private static boolean BFS(int start, int end) {

        boolean[] visited = new boolean[graph.length];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (queue.size() > 0) {
            int current = queue.poll();
            visited[current] = true;

            for (int child = 0; child < graph[current].length; child++) {
                if (!visited[child] && graph[current][child] > 0) {
                    queue.offer(child);
                    parents[child] = current;
                }
            }
        }
        return visited[end];
    }


}
