//공유기 설치

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            house[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(house);

        int result = binarySearch(house);

        System.out.println(result);
    }

    public static int binarySearch(int[] house) {
        int left = 0;
        int right = house[N - 1] - house[0];
        int result = 0;
        int current, count;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            current = house[0];
            count = 1;
            for (int i = 0; i < N; i++) {
                if (house[i] >= current + mid) {
                    current = house[i];
                    count += 1;
                }
            }

            if (count >= C) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
