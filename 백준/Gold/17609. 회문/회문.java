// 회문

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            int left = two_pointer_left(word);
            int right = two_pointer_right(word);
            System.out.println(Math.min(left, right));
        }
    }

    private static int two_pointer_left(String word) {
        boolean check = false;
        int left = 0;
        int right = word.length() - 1;
        while (left <= right) {
            if (word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            } else if (!check && (word.charAt(left + 1) == word.charAt(right))) {
                left += 2;
                right--;
                check = true;
            } else {
                return 2;
            }
        }
        if (check) {
            return 1;
        }
        return 0;
    }

    private static int two_pointer_right(String word) {
        boolean check = false;
        int left = 0;
        int right = word.length() - 1;
        while (left <= right) {
            if (word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            } else if (!check && (word.charAt(left) == word.charAt(right - 1))) {
                left++;
                right -= 2;
                check = true;
            } else {
                return 2;
            }
        }
        if (check) {
            return 1;
        }
        return 0;
    }
}