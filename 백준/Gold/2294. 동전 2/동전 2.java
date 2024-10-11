//동전2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int[] coins;
    static int[] d;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        coins = new int[K];
        N = Integer.parseInt(st.nextToken());
        d = new int[N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            d[i] = INF;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && d[i - coin] != INF) {
                    int temp = d[i - coin] + 1;
                    if (d[i] > temp) {
                        d[i] = temp;
                    }
                }
            }
        }

        if (d[N] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(d[N]);
        }
    }
}
