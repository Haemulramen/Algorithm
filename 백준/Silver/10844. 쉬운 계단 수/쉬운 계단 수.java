//쉬운 계단 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = new long[N][10];
        for (int i = 1; i < 10; i++) {
            d[0][i] = 1;
        }

        int div = 1000000000;
        for (int i = 1; i < N; i++) {
            d[i][0] = d[i - 1][1] % div;
            for (int j = 1; j < 9; j++) {
                d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % div;
            }
            d[i][9] = d[i - 1][8] % div;
        }

        long res = Arrays.stream(d[N - 1]).sum() % div;
        System.out.println(res);
    }
}
