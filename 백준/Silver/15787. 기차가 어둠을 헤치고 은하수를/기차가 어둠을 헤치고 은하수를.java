import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int command, t, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringBuilder[] train = new StringBuilder[N];
        for (int i = 0; i < N; i++) {
            train[i] = new StringBuilder("00000000000000000000");
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken()) - 1;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken()) - 1;
            }

            switch (command) {
                case 1:
                    train[t].replace(x, x + 1, "1");
                    break;
                case 2:
                    train[t].replace(x, x + 1, "0");
                    break;
                case 3:
                    for (int j = 19; j > 0; j--) {
                        train[t].replace(j, j + 1, train[t].substring(j - 1, j));
                    }
                    train[t].replace(0, 1, "0");
                    break;
                case 4:
                    for (int j = 0; j < 19; j++) {
                        train[t].replace(j, j + 1, train[t].substring(j + 1, j + 2));
                    }
                    train[t].replace(19, 20, "0");
                    break;
                default:
                    break;
            }
        }

        int res = 1;
        for (int i = 1; i < N; i++) {
            int temp = 1;
            for (int j = 0; j < i; j++) {
                if (train[i].compareTo(train[j]) == 0) {
                    temp = 0;
                    break;
                }
            }
            res += temp;
        }

        System.out.println(res);
    }
}
