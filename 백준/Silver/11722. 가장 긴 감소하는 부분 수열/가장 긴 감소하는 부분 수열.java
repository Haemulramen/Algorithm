//가장 긴 감소하는 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        d = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        d[0] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] < numbers[j] && d[i] < d[j]) {
                    d[i] = d[j];
                }
            }
            d[i]++;
        }

        System.out.println(Arrays.stream(d).max().getAsInt());
    }
}
