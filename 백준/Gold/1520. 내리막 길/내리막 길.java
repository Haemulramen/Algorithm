//내리막 길

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(dp[N - 1][M - 1]);
    }

    static int dfs(int x, int y) {
        //목적지에 도착한 경우
        if (x == N - 1 && y == M - 1) {
            dp[N - 1][M - 1]++;
            return 1;
        }

        //현재 위치가 이전에 방문한 경로
        if (visited[x][y] == 1) {
            //현재 위치를 거쳤을 때 목적지에 도달하지 못한 경로인 경우
            if (dp[x][y] == 0) {
                return 0;
            }
            //현재 위치가 이전에 목적지에 도달한 경로의 일부인 경우
            else if (dp[x][y] > 0) {
                dp[N - 1][M - 1] += dp[x][y];
                return dp[x][y];
            }
        } else {
            visited[x][y] = 1;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }
            if (map[nx][ny] < map[x][y]) {
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }
}
