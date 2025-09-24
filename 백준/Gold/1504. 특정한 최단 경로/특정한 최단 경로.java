import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int infinite = 999999999;
    static int N, E;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], infinite);
        }

        for (int i = 1; i <= N; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[x][y] = dist;
            graph[y][x] = dist;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist1 = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);

        long path1 = (long)dist1[v1] + distV1[v2] + distV2[N];

        long path2 = (long)dist1[v2] + distV2[v1] + distV1[N];

        long answer = Math.min(path1, path2);

        System.out.println(answer >= infinite ? -1 : (int)answer);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, infinite);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int vertex = cur[0];
            int distance = cur[1];

            if (visited[vertex]) continue;
            visited[vertex] = true;

            for (int next = 1; next <= N; next++) {
                if (!visited[next] && graph[vertex][next] != infinite) {
                    int weight = graph[vertex][next];
                    if (dist[vertex] + weight < dist[next]) {
                        dist[next] = dist[vertex] + weight;
                        pq.offer(new int[]{next, dist[next]});
                    }
                }
            }
        }

        return dist;
    }
}