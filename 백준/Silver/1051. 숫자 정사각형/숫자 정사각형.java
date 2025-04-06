import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] rectangle;
    static int W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        rectangle = new int[H][W];

        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                rectangle[i][j] = input.charAt(j) - '0';
            }
        }

        solve();
    }

    public static void solve() {
        int res = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for (int k = 0; k < W; k++) {
                    if (i + k >= H || j + k >= W) {
                        break;
                    }
                    int num = rectangle[i][j];
                    if (num == rectangle[i][j + k] && num == rectangle[i + k][j] && num == rectangle[i + k][j + k]) {
                        res = Math.max(res, (int) Math.pow(k + 1, 2));
                    }
                }
            }
        }

        System.out.println(res);
    }
}
