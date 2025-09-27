import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] queens;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        queens = new int[N];

        nqueen(0);
        System.out.println(answer);
    }

    static void nqueen(int idx) {
        if (idx == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            queens[idx] = i;

            if (check(idx)) {
                nqueen(idx + 1);
            }
        }
    }

    static boolean check(int idx) {
        for (int i = 0; i < idx; i++) {
            if (queens[i] == queens[idx] || idx - i == Math.abs(queens[idx] - queens[i])) {
                return false;
            }
        }

        return true;
    }
}
