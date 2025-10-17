import java.util.*;

class Solution {
    
    static Map<String, Boolean> map;
    static int answer = Integer.MAX_VALUE;
    static String target;
    
    public int solution(String begin, String target, String[] words) {
        this.map = new HashMap<>();
        this.target = target;
        
        for (String word : words) {
           map.put(word, false); 
        }
        
        if (!map.keySet().contains(target))
            return 0;
        
        Set<String> history = new HashSet<>();
        history.add(begin);
        dfs(begin, history);
        
        return answer;
    }
    
    boolean isChangeable(String from, String target) {
        int cnt = 0;
        
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != target.charAt(i))
                cnt++;
        }
        
        return cnt == 1 ? true : false;
    }
    
    void dfs(String cur, Set<String> history) {
        if (cur.equals(target)) {
            answer = Math.min(answer, history.size() - 1);
            return;
        }
        
        Set<String> set = new HashSet<>(history);
        
        for (String word : map.keySet()) {
            if (!isChangeable(cur, word) || history.contains(word)) continue;
            
            set.add(word);
            dfs(word, set);
            set.remove(word);
        }
    }
}