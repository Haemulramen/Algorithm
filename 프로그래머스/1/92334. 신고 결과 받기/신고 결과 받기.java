import java.util.*;
import java.util.stream.*;

class Solution {
    
    boolean[][] data;
    Map<String, Integer> reported = new HashMap<>();
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        for (String id : id_list) {
            reported.put(id, 0);
        }
        data = new boolean[id_list.length][id_list.length];
        
        for (String rep : report) {
            String[] split = rep.split(" ");
            int i = findIndex(id_list, split[0]);
            int j = findIndex(id_list, split[1]);
            if (!data[i][j]) {
                data[i][j] = true;
                reported.put(split[1], reported.get(split[1]) + 1);
            }
        }
        
        Map<String, Integer> filtered = reported.entrySet().stream()
                                    .filter(entry -> entry.getValue() >= k)
                                    .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue
                                    ));
        
        for (String id : filtered.keySet()) {
            int j = findIndex(id_list, id);
            for (int i = 0; i < id_list.length; i++) {
                if (data[i][j]) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
    
    public int findIndex(String[] id_list, String id) {
        for (int i = 0; i < id_list.length; i++) {
            if (id_list[i].equals(id)) {
                return i;
            }
        }
        return -1;
    }
}