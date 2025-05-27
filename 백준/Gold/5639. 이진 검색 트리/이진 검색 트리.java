import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] tree = new int[10000];
    static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) break;

            tree[n++] = Integer.parseInt(input);
        }

        solve(0, n - 1);
    }

    static void solve(int cur, int end) {
        if (cur == end) {
            System.out.println(tree[cur]);
            return;
        }

        int mid = cur + 1;
        while (mid <= end && tree[mid] < tree[cur]) {
            mid++;
        }

        if (cur + 1 <= mid - 1) solve(cur + 1, mid - 1);
        if (mid <= end) solve(mid, end);
        System.out.println(tree[cur]);
    }
}
