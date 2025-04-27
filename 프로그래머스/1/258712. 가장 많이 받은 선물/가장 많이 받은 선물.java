import java.util.*;

class Solution {
    
    static int N;
    static Map<String, Integer> names = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        N = friends.length;
        for (int i = 0; i < N; i++) {
            names.put(friends[i], i);
        }
        int[][] data = new int[N][N];
        
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            int sender = names.get(split[0]);
            int receiver = names.get(split[1]);
            data[sender][receiver]++;
        }
        
        return solve(data);
    }
    
    private int solve(int[][] data) {
        int res = 0, temp = 0;
        
        for (int i = 0; i < N; i++) {
            temp = 0;
            for (int j = 0; j < N; j++) {
                if (data[i][j] > data[j][i]) temp++;
                else if (data[i][j] == data[j][i]) {
                    int ii = calculate(i, data);
                    int jj = calculate(j, data);
                    
                    if (ii > jj) temp++;
                }
            }
            res = Math.max(res, temp);
        }
        
        return res;
    }
    
    private int calculate(int x, int[][] data) {
        int res = 0;
        
        for (int i = 0; i < N; i++) {
            res += data[x][i];
            res -= data[i][x];
        }
        
        return res;
    }
}