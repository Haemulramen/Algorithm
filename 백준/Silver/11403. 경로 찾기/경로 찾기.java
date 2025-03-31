import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] graph, map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
    }

    public static void solve() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            q.add(i);

            while (!q.isEmpty()) {
                int num = q.poll();
                for (int j = 0; j < N; j++) {
                    if (graph[num][j] == 1 && map[i][j] == 0) {
                        map[i][j] = 1;
                        q.add(j);
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
