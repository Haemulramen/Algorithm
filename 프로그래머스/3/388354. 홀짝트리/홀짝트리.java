import java.util.*;

class Solution {
    
    // static int[] counts = new int[1000001];
    static List<Integer>[] lines = new List[1000001];
    static int common = 0, reverse = 0;
    static boolean[] upper = new boolean[1000001];
    
    public int[] solution(int[] nodes, int[][] edges) {
        for (int i = 0; i <= 1000000; i++) {
            lines[i] = new LinkedList<>();
        }
        
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            lines[a].add(b);
            lines[b].add(a);
        }
        
        for (int node : nodes) {
            int childCnt = lines[node].size();
            solve(node, childCnt % 2 == node % 2);
            Arrays.fill(upper, false);
        }
        
        return new int[]{common, reverse};
    }
    
    void solve(int node, boolean tree) {
        upper[node] = true;
        for (int child : lines[node]) {
            if (!dfs(child, tree)) return;
        }
        
        if (tree) common++;
        else reverse++;
    }
    
    boolean dfs(int node, boolean tree) {
        int childCnt = lines[node].size() - 1;
        if ((node % 2 == childCnt % 2) != tree) return false;
        upper[node] = true;
        
        for (int child : lines[node]) {
            if (upper[child]) continue;
            if (!dfs(child, tree)) return false;
        }
        
        return true;
    }
}