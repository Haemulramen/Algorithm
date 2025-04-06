import java.util.Scanner;

public class Main {

    static int[] dp = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        init();
        System.out.println(dp[num]);
    }

    public static void init() {
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= 100000; i++) {
            dp[i] = 100000;
            for (int j = 0; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
    }
}
