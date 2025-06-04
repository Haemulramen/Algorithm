class Solution {
    
    static int[] update, servers;
    
    public int solution(int[] players, int m, int k) {
        update = new int[24];
        servers = new int[24];
        
        for (int i = 0; i < 24; i++) {
            if (i >= k) {
                servers[i] = servers[i - 1] - update[i - k];
            } else if (i >= 1) {
                servers[i] = servers[i - 1];
            }
            
            int n = players[i] / m;
            if (servers[i] < n) {
                update[i] = n - servers[i];
                servers[i] = n;
            }
        }
        
        int answer = 0;
        for (int i = 0; i < 24; i++) answer += update[i];
        
        return answer;
    }
}