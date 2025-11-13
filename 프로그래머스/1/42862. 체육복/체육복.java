import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] d = new int[n + 2];
        Arrays.fill(d, 1);
        d[0] = d[n + 1] = 0;
        
        for (int l : lost) {
            d[l]--;
        }
        
        for (int r : reserve) {
            d[r]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                if (d[i - 1] == 2) {
                    d[i]++;
                    d[i - 1]--;
                } else if (d[i + 1] == 2) {
                    d[i]++;
                    d[i + 1]--;
                }
            }
        }
        
        int answer = 0;
        for (int i : d) {
            if (i != 0) answer++;
        }
        
        return answer;
    }
}