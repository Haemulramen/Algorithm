import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp, data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            dp = new int[3][N];
            data = new int[3][N];

            for (int i = 1; i <= 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][0] = data[1][0];
            dp[2][0] = data[2][0];

            for (int i = 1; i < N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]);
                dp[1][i] = Math.max(dp[0][i - 1], dp[2][i - 1]) + data[1][i];
                dp[2][i] = Math.max(dp[0][i - 1], dp[1][i - 1]) + data[2][i];
            }

            int num0, num1, num2;
            if (N != 1) {
                num0 = Math.max(dp[0][N - 2], dp[0][N - 1]);
                num1 = Math.max(dp[1][N - 2], dp[1][N - 1]);
                num2 = Math.max(dp[2][N - 2], dp[2][N - 1]);
            } else {
                num0 = data[0][0];
                num1 = data[1][0];
                num2 = data[2][0];
            }


            int res = Math.max(Math.max(num0, num1), num2);
            System.out.println(res);
        }
    }
}
