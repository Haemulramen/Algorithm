// 문자열 게임 2

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            int min = 2000000000;
            int max = 0;
            String temp = sc.nextLine();
            int length = temp.length();
            char[] word = temp.toCharArray();
            int K = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < 26; j++) {
                int ch = 'a' + j;
                int start = temp.indexOf(ch);
                int end = start;
                int cnt = 0;
                while (start != -1 && cnt < K && end < length) {
                    if (word[end] == ch) {
                        cnt++;
                    }
                    if (cnt == K) {
                        min = Math.min(min, end - start + 1);
                        max = Math.max(max, end - start + 1);
                        int n = temp.substring(start + 1).indexOf(ch) + 1;
                        if (n == 0) {
                            break;
                        }
                        start += n;
                        cnt--;
                    }
                    end++;
                }
            }
            if (max == 0) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}
