import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T, N;
    static int[] dx = {2, 2, 1, -1, -2, -2, -1, 1};
    static int[] dy = {1, -1, -2, -2, -1, 1, 2, 2};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            Position start = new Position(st);
            st = new StringTokenizer(br.readLine());
            Position target = new Position(st);

            solve(start, target);
        }
    }

    public static void solve(Position start, Position target) {
        Queue<Position> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Position cur = q.poll();
            if (visited[cur.y][cur.x]) {
                continue;
            } else {
                visited[cur.y][cur.x] = true;
            }

            if (cur.equals(target)) {
                System.out.println(cur.cnt);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                    continue;
                }

                if (!visited[ny][nx]) {
                    q.add(new Position(ny, nx, cur.cnt + 1));
                }
            }
        }
    }

    public static class Position {
        int x;
        int y;
        int cnt;

        public boolean equals(Object o) {
            Position p = (Position) o;
            if (this.x == p.x && this.y == p.y) {
                return true;
            }
            return false;
        }

        public Position(StringTokenizer st) {
            this.x = Integer.parseInt(st.nextToken());
            this.y = Integer.parseInt(st.nextToken());
            this.cnt = 0;
        }

        public Position(int y, int x, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
