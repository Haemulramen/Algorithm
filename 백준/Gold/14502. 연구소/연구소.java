//연구소

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, res = 0;
    static int[][] original;
    static int[][] copy;
    static List<int[]> virus = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int first, second, third;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        original = new int[N][M];
        copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                original[i][j] = Integer.parseInt(st.nextToken());
                if (original[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
            copy[i] = original[i].clone();
        }

        for (int i = 0; i < N * M - 2; i++) {
            if (original[i / M][i % M] != 0) {
                continue;
            }
            for (int j = i + 1; j < N * M - 1; j++) {
                if (original[j / M][j % M] != 0) {
                    continue;
                }
                for (int k = j + 1; k < N * M; k++) {
                    if (original[k / M][k % M] != 0) {
                        continue;
                    }
                    copy[i / M][i % M] = 1;
                    copy[j / M][j % M] = 1;
                    copy[k / M][k % M] = 1;
                    for (int[] v : virus) {
                        dfs(v[0], v[1]);
                    }
                    check();
                    for (int h = 0; h < N; h++) {
                        copy[h] = original[h].clone();
                    }
                }
            }
        }
        System.out.println(res);
    }

    static void check() {
        int temp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0) {
                    temp++;
                }
            }
        }
        if (res < temp) {
            res = temp;
        }
    }

    static void dfs(int x, int y) {
        copy[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }
            if (copy[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }
    }

    static int next_wall(int pos) {
        while (original[pos / M][pos % M] != 0) {
            pos++;
            if (pos >= N * M) {
                return -1;
            }
        }
        copy[pos / M][pos % M] = 1;
        return pos;
    }
}
