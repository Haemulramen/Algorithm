import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] rope;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        rope = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rope[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(rope);

        int weight = rope[0];
        int total = weight * N;
        for (int i = 1; i < N; i++) {
            if (weight < rope[i]){
                int temp = rope[i];
                int tempTotal = temp * (N - i);
                if (tempTotal > total) {
                    total = tempTotal;
                }
                weight = rope[i];
            }
        }
        System.out.println(total);
    }
}
