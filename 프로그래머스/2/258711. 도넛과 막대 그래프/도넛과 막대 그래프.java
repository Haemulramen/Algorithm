import java.util.*;

class Solution {
    
    static int N = 0;
    static int[] in = new int[1000001];
    static List<Integer>[] out = new List[1000001];
    static boolean[] visited;
    
    public int[] solution(int[][] edges) {
        int[] answer = {0, 0, 0, 0};
        int root = 0;
        
        for (int i = 1; i <= 1000000; i++) {
            out[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            out[edge[0]].add(edge[1]);
            in[edge[1]]++;
            
            N = Math.max(N, Math.max(edge[0], edge[1]));
        }
        visited = new boolean[N + 1];
        
        for (int i = 1; i <= N; i++) {
            if (in[i] == 0 && out[i].size() >= 2) {
                root = i;
                answer[0] = root;
                break;
            }
        }
        
        for (int i = 0; i < out[root].size(); i++) {
            Arrays.fill(visited, false);
            solve(out[root].get(i), answer);
        }
        
        return answer;
    }
    
    private void solve(int x, int[] answer) {
        visited[x] = !visited[x];
        
        if (!visited[x]) {
            answer[1]++;
            return;
        }
        else if (out[x].size() == 0) {
            answer[2]++;
            return;
        } else if (out[x].size() == 2) {
            answer[3]++;
            return;
        }
        
        solve(out[x].get(0), answer);
    }
}