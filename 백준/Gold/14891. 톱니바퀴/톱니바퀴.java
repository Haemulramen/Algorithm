import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T, N = 0, S = 1;
    static int[] wheels = new int[4];
    static boolean[] check = new boolean[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String wheel = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i] = wheels[i] << 1;
                if (wheel.charAt(j) == '1') {
                    wheels[i] |= 1;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Arrays.fill(check, false);
        }

        count();
    }

    static void solve(int n, int x) {
        check[n - 1] = true;
        int cur = wheels[n - 1];

        if (x == 1) {
            int temp = cur & 1;
            cur >>= 1;
            cur |= temp << 7;
        } else {
            int msb = cur & 0b10000000;
            cur = cur << 1;
            cur |= msb >> 7;
            cur &= 0b11111111;
        }

        if (n < 4 && !check[n]) {
            int rightTooth = (wheels[n] >> 1) & 1;
            int leftTooth = (wheels[n - 1] >> 5) & 1;
            if (rightTooth != leftTooth) {
                solve(n + 1, x == 1 ? -1 : 1);
            }
        }

        if ( n > 1 && !check[n - 2]) {
            int rightTooth = (wheels[n - 1] >> 1) & 1;
            int leftTooth = (wheels[n - 2] >> 5) & 1;
            if (rightTooth != leftTooth) {
                solve(n - 1, x == 1 ? -1 : 1);
            }
        }

        wheels[n - 1] = cur;
    }

    static void count() {
        int result = 0;

        for (int i = 0; i < 4; i++) {
            int cur = wheels[i];
            if ((cur & 0b10000000) == 128) {
                result += (int) Math.pow(2, i);
            }
        }

        System.out.println(result);
    }
}
