//가장 긴 증가하는 부분 수열 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[] numbers;
    public static List<Integer> dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        dp = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        dp.add(0);

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (dp.get(dp.size() - 1) < num) {
                dp.add(num);
            } else {
                int left = 0;
                int right = dp.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;
                    if (dp.get(mid) >= num) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                dp.set(right, num);
            }
        }

        System.out.println(dp.size() - 1);
    }
}
