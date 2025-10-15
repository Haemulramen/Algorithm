import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = progresses.length - 1; i >= 0; i--) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0)
                day++;
            
            stack.push(day);
        }
        
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            int day = stack.peek();
            int cnt = solve(stack, day);
            list.add(cnt);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
    
    int solve(Stack<Integer> stack, int day) {
        if (stack.isEmpty() || stack.peek() > day) {
        return 0;
    }
    
    stack.pop();
    
    return solve(stack, day) + 1;
    }
}