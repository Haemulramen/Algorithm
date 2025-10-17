import java.util.*;

class Solution {
    
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                q.add(i);
                answer++;
            }
            
            while (q.size() != 0) {
                int com = q.poll();

                if (visited[com]) continue;
                visited[com] = true;

                for (int j = 0; j < n; j++) {
                    if (computers[com][j] == 1) {
                        q.add(j);
                    }
                }
            }
        }
        
        return answer;
    }
}