import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        //k진수 만들기
        while (n != 0) {
            int i = n % k;
            n /= k;
            sb.insert(0, i);
        }
        String kNum = sb.toString();
        String[] split = kNum.split("0+");
        
        for (String s : split) {
            answer += checkPrime(s);
        }
        
        return answer;
    }
    
    public int checkPrime(String s) {
        long n = Long.parseLong(s);
        if (n <= 1) return 0;
        if (n <= 3) return 1;
        if (n % 2 == 0 || n % 3 == 0) return 0;
        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return 0;
        }
        return 1;
    }
}