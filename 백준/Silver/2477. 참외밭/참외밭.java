//참외밭

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dir = new int[6];
    static int[] length = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int length_temp = 0, idx_temp = 0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());
            if (length_temp < length[i]) {
                length_temp = length[i];
                idx_temp = i;
            }
        }

        int size = getSize(length_temp, idx_temp);
        System.out.println(size * N);
    }

    public static int getSize(int length_temp, int idx_temp) {
        int result = 0;
        int left = (idx_temp + 5) % 6;
        int right = (idx_temp + 1) % 6;
        if (length[left] < length[right]) {
            result = length_temp * length[right];
            int temp = (right + 1) % 6;
            result -= (length_temp - length[temp]) * (length[right] - length[left]);
        } else {
            result = length_temp * length[left];
            int temp = (left + 5) % 6;
            result -= (length_temp - length[temp]) * (length[left] - length[right]);
        }

        return result;
    }
}
