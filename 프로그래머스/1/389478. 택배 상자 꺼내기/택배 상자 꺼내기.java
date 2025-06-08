import java.util.*;

class Solution {
    
    Stack<Integer>[] stacks;
    
    public int solution(int n, int w, int num) {
        init(w);
        return solve(n, w, num);
    }
    
    void init(int w) {
        stacks = new Stack[w + 1];
        for (int i = 0; i <= w; i++) {
            stacks[i] = new Stack<>();
        }
    }
    
    int findPosition(int w, int num) {
        int share = num / w;
        int remainder = num % w;
        
        if (remainder == 0) {
            remainder = w;
            share--;
        }
        
        if (share % 2 == 0) {
            return remainder;
        } else {
            return w + 1 - remainder;
        }
    }
    
    int solve(int n, int w, int num) {
        for (int i = 1; i <= n; i++) {
            int pos = findPosition(w, i);
            stacks[pos].push(i);
        }
        
        int pos = findPosition(w, num);
        int result = 0;
        while (stacks[pos].pop() != num) {
            result++;
        }
        
        return result + 1;
    }
}