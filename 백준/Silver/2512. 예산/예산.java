import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] towns;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        towns = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            towns[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        System.out.println(solve());
    }

    public static int solve() {
        int total = 0, maxTown = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            total += towns[i];
            if (towns[i] > maxTown) {
                maxTown = towns[i];
            }
        }

        if (total <= M) {
            return maxTown;
        } else {
            return findLimit(maxTown);
        }
    }

    public static int findLimit(int maxTown) {
        int left = 0, right = maxTown, res = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int total = 0;

            for (int town : towns) {
                if (town < mid) {
                    total += town;
                } else {
                    total += mid;
                }
            }

            if (total <= M) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}
