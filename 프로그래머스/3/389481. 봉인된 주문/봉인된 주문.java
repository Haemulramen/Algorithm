import java.util.*;

class Solution {
    
    public String solution(long n, String[] bans) {
        long[] banned = new long[bans.length];
        
        for (int i = 0; i < bans.length; i++) {
            banned[i] = stringToLong(bans[i]);
        }
        
        Arrays.sort(banned);
        
        for (int i = 0; i < banned.length; i++) {
            if (banned[i] <= n) {
                n++;
            }
        }
        
        System.out.println(longToString(26));
        return longToString(n);
    }
    
    long stringToLong(String string) {
        int len = string.length();
        long num = 0;
        for (int i = 0; i < len; i++) {
            char ch = string.charAt(i);
            
            num += Math.pow(26, len - i - 1) * (ch - 'a' + 1);
        }
        
        return num;
    }
    
    String longToString(long num) {
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            long n = num % 26;
            num /= 26;
            
            if (n == 0) {
                n = 26;
                num--;
            }
            
            sb.insert(0, (char) ('a' + n - 1));
        }
        
        return sb.toString();
    }
}