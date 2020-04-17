import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Salaries {

    private static List<Integer>[] graph;
    private static boolean [] visited;
    private static long[] salaries;

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        graph = new ArrayList[n];
        visited = new boolean[n];
        salaries = new long[n];

        for (int i = 0; i < n; i++) {
            if (graph[i] == null){
                graph[i] = new ArrayList<>();
            }

            String [] children = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                if (children[j].equals("Y")){
                    graph[i].add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            CalculateSalaries(i);
        }

        System.out.println(Arrays.stream(salaries).sum());

    }

    private static void CalculateSalaries(int vertex) {

        if (salaries[vertex] !=0 || visited[vertex]){
            return;
        }

        if (graph[vertex].size() == 0){
            salaries[vertex] = 1;
            return;
        }

        visited[vertex] = true;
        long sum = 0;
        for (int child : graph[vertex]){
            if (salaries[child] == 0){
                CalculateSalaries(child);
            }
            sum += salaries[child];
        }
        salaries[vertex] = sum;

    }
}
