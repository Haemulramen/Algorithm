import java.util.*;

class Solution {
    
    private Map<String, Integer> map;
    private int max;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int c : course) {
            max = 0;
            map = new HashMap<>();
            
            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                order = new String(arr);
                dfs(order, "", -1, c, 0);
            }
            
            for (String key : map.keySet()) {
                int value = map.get(key);
                if (value > 1 && value == max) {
                    answer.add(key);
                }
            }
        }
        
        
        
        Collections.sort(answer);
        String[] result = answer.toArray(new String[answer.size()]);
        
        return result;
    }
    
    private void dfs(String arr, String key, int idx, int limit, int depth) {
        if (depth == limit) {
            map.put(key, map.getOrDefault(key, 0) + 1);
            max = Math.max(max, map.get(key));
        }
        
        for (int i = idx + 1; i < arr.length(); i++) {
            dfs(arr, key + arr.charAt(i), i, limit, depth + 1);
        }
    }
}