//단지번호붙이기

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, cnt;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        cnt = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != '0') {
                    dfs(arr, i, j);
                    res.add(cnt);
                    cnt = 0;
                }
            }
        }

        Collections.sort(res);
        System.out.println(res.size());
        for (Integer re : res) {
            System.out.println(re);
        }
    }

    static void dfs(char[][] arr, int x, int y) {
        cnt++;
        arr[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (arr[nx][ny] != '0') {
                dfs(arr, nx, ny);
            }
        }
    }
}
