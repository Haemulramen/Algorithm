//원상 복구 (small)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] card;
    static int[] shuffle;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        card = new int[N + 1];
        shuffle = new int[N + 1];
        d = new int[K + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            shuffle[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            d[0][i] = card[i];
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j < N + 1; j++) {
                d[i][shuffle[j]] = d[i - 1][j];
            }
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.print(d[K][i] + " ");
        }
    }
}
