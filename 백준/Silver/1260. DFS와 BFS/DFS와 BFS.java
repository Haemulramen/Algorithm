import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }

        dfs(graph, V);
        System.out.println();
        bfs(graph);
    }

    static void dfs(List<Integer>[] graph, int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (Integer next : graph[v]) {
            if (!visited[next]) {
                dfs(graph, next);
            }
        }
    }

    static void bfs(List<Integer>[] graph) {
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        while (!queue.isEmpty()) {
            int now = queue.poll().intValue();
            if (!visited[now]) {
                visited[now] = true;
                System.out.print(now + " ");
                queue.addAll(graph[now]);
            }
        }
    }
}
