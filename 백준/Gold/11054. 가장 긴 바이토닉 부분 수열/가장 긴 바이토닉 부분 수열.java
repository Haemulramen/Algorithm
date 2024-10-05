//가장 긴 바이토닉 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        d = new int[2][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        //dp 배열 초기화
        d[0][0] = 1;
        d[1][N - 1] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j] && d[0][i] < d[0][j]) {
                    d[0][i] = d[0][j];
                }
            }
            d[0][i]++;
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (numbers[i] > numbers[j] && d[1][i] < d[1][j]) {
                    d[1][i] = d[1][j];
                }
            }
            d[1][i]++;
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (res < d[0][i] + d[1][i]) {
                res = d[0][i] + d[1][i];
            }
        }
        System.out.println(res - 1);
    }
}
