//욕심쟁이 판다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] forest;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        forest = new int[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int temp = 0;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp = dfs(i, j);
                if (res < temp) {
                    res = temp;
                }
            }
        }

        System.out.println(res);
    }

    static int dfs(int x, int y) {
        if (visited[x][y] != 0) {
            return visited[x][y];
        }

        int temp = 0;
        int res = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (forest[nx][ny] > forest[x][y]) {
                temp = dfs(nx, ny) + 1;
            }

            if (temp > res) {
                res = temp;
            }
        }

        visited[x][y] = res;
        return res;
    }
}
