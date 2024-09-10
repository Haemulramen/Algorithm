import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union_parent(parent, a, b);
        }

        int root = find_parent(parent, 1);
        int res = 0;
        for (int i = 1; i < N + 1; i++) {
            if (find_parent(parent, i) == root) {
                res++;
            }
        }
        System.out.println(--res);
    }

    static int find_parent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find_parent(parent, parent[x]);
        }
        return parent[x];
    }

    static void union_parent(int[] parent, int x, int y) {
        x = find_parent(parent, x);
        y = find_parent(parent, y);
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}
