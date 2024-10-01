//오목

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[19][19];

    //방향 별 카운트 용
    static int[][][] d = new int[19][19][4];

    //아래, 오른쪽 아래, 오른쪽, 오른쪽 위
    static int[] dx = {1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find();
    }

    static void find() {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[j][i] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int res = check(j, i, k, board[j][i]);
                        if (res == 5) {
                            System.out.println(board[j][i]);
                            System.out.println((j + 1) + " " + (i + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("0");
    }

    static int check(int x, int y, int direction, int color) {
        int nx = x + dx[direction];
        int ny = y + dy[direction];
        if (nx >= 19 || ny >= 19 || ny < 0 || nx < 0) {
            return 1;
        }
        if (d[nx][ny][direction] == 0 && board[nx][ny] == color) {
            d[nx][ny][direction] = check(nx, ny, direction, color) + 1;
            return d[nx][ny][direction];
        }
        return 1;
    }
}
