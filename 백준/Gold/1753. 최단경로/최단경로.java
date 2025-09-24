import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E;
    static List<int[]>[] graph;
    static int infinite = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        graph = new List[V + 1];
        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[x].add(new int[]{y, weight});
        }

        int[] dist = dijkstra(start);
        for (int i = 1; i < V + 1; i++) {
            System.out.println(dist[i] == infinite ? "INF" : dist[i]);
        }
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, infinite);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int vertex = cur[0];
            int distance = cur[1];

            if (distance > dist[vertex]) continue;

            for (int[] edge : graph[vertex]) {
                int next = edge[0];
                int weight = edge[1];

                if (dist[vertex] + weight < dist[next]) {
                    dist[next] = dist[vertex] + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        return dist;
    }
}
