import java.util.*;

class Solution {
    
    static final int INFINITE = Integer.MAX_VALUE;
    static int[][] graph;
    static int[][] fares;
    static int[][] shortestPath;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        init(fares, n);
        for (int i = 1; i <= n; i++) buildShortestPath(n, i);
        
        return solve(n, s, a, b);
    }
    
    void init(int[][] fares, int n) {
        shortestPath = new int[201][201];
        for (int[] arr : shortestPath) Arrays.fill(arr, INFINITE);
        
        graph = new int[201][201];
        for (int[] arr : graph) Arrays.fill(arr, INFINITE);
        
        for (int[] fare : fares) {
            graph[fare[0]][fare[1]] = fare[2];
            graph[fare[1]][fare[0]] = fare[2];
        }
    }
    
    void buildShortestPath(int n, int s) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        shortestPath[s] = graph[s];
        shortestPath[s][s] = 0;
        list.add(s);
        visited[s] = true;
        
        while (list.size() != n) {
            int pos = 0, min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && shortestPath[s][i] != INFINITE && shortestPath[s][i] < min) {
                    min = shortestPath[s][i];
                    pos = i;
                }
            }
            
            visited[pos] = true;
            list.add(pos);
            
            for (int i = 1; i <= n; i++) {
                if (graph[pos][i] != INFINITE) {
                    shortestPath[s][i] = Math.min(shortestPath[s][i], min + graph[pos][i]);
                }
            }
        }
    }
    
    int solve(int n, int s, int a, int b) {
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (shortestPath[s][i] == INFINITE
               || shortestPath[i][a] == INFINITE
               || shortestPath[i][b] == INFINITE) continue;
            int temp = shortestPath[s][i] + shortestPath[i][a] + shortestPath[i][b];
            result = Math.min(result, temp);
        }
        
        return result;
    }
}