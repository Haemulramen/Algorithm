import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        Deque<Integer> code = new LinkedList<>();
        
        dfs(0, 1, code, n, q, ans);
        
        return answer;
    }
    
    private void dfs(int cnt, int x, Deque<Integer> code, int n, int[][]q, int[] ans) {
        if (cnt == 5){
            for (int i = 0; i < q.length; i++) {
                int contain = 0;
                for (int j = 0; j < q[i].length; j++) {
                    if (code.contains(q[i][j])) contain++;
                }
                if (contain != ans[i]) return;
            }
            answer++;
        }
        
        for (int i = x; i <= n; i++) {
            code.addLast(i);
            dfs(cnt + 1, i + 1, code, n, q, ans);
            code.pollLast();
        }
    }
}