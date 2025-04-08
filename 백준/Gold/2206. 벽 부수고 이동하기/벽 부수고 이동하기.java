import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][][] visited;
    static int H, W;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new int[2][H][W];

        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs();
    }

    public static void bfs() {
        if (H == 1 && W == 1) {
            System.out.println(1);
            return;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1, 0}); // 행, 열, 이동 횟수, 벽 부시기

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
                    continue;
                }

                if (cur[3] == 0) {
                    if (map[nr][nc] == 0 && visited[0][nr][nc] == 0) {
                        visited[0][nr][nc] = cur[2] + 1;
                        q.add(new int[]{nr, nc, cur[2] + 1, cur[3]});

                        if (nr == H - 1 && nc == W - 1) {
                            System.out.println(cur[2] + 1);
                            return;
                        }
                    }
                    if (map[nr][nc] == 1) {
                        visited[1][nr][nc] = cur[2] + 1;
                        q.add(new int[]{nr, nc, cur[2] + 1, 1});

                        if (nr == H - 1 && nc == W - 1) {
                            System.out.println(cur[2] + 1);
                            return;
                        }
                    }
                } else if (cur[3] == 1) {
                    if (map[nr][nc] == 0 && visited[1][nr][nc] == 0) {
                        visited[1][nr][nc] = cur[2] + 1;
                        q.add(new int[]{nr, nc, cur[2] + 1, cur[3]});

                        if (nr == H - 1 && nc == W - 1) {
                            System.out.println(cur[2] + 1);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
