import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        
        List<String> path = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        
        stack.push("ICN");
        
        while (!stack.isEmpty()) {
            String cur = stack.peek();
            
            if (graph.containsKey(cur) && !graph.get(cur).isEmpty()) {
                String next = graph.get(cur).poll();
                stack.push(next);
            } else {
                path.add(stack.pop());
            }
        }
        
        Collections.reverse(path);
        
        return path.toArray(new String[0]);
    }
}