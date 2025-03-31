// 치킨 배달

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] village;
    static List<Position> houses = new ArrayList<>();
    static List<Position> chickens = new ArrayList<>();
    static boolean[] opened;
    static Position[] openedChickens;
    static int res = Integer.MAX_VALUE, cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        village = new int[N][N];
        openedChickens = new Position[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    houses.add(new Position(i, j));
                } else if (map[i][j] == 2) {
                    chickens.add(new Position(i, j));
                }
            }
        }
        opened = new boolean[chickens.size()];

        for (int i = 0; i <= opened.length - M; i++) {
            dfs(i);
        }

        System.out.println(res);
    }

    public static int solve() {
        int dist, temp, total = 0;
        for (Position house : houses) {
            dist = Integer.MAX_VALUE;
            for (Position chicken : openedChickens) {
                temp = calculateDistance(house, chicken);
                dist = Math.min(dist, temp);
            }
            total += dist;
        }

        return total;
    }

    public static void setChickens() {
        int x = 0;
        for (int i = 0; i < opened.length; i++) {
            if (opened[i]) {
                openedChickens[x++] = chickens.get(i);
            }
        }
    }

    public static void dfs(int x) {
        opened[x] = true;
        cnt++;

        if (cnt < M) {
            for (int i = x; i < opened.length - 1; i++) {
                dfs(i + 1);
            }
        } else {
            setChickens();
            int temp = solve();
            res = Math.min(res, temp);
        }

        opened[x] = false;
        cnt--;
    }

    public static int calculateDistance(Position a, Position b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
