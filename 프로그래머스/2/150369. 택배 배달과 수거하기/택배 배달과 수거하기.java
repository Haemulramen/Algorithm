import java.util.*;

class Solution {
    
    static Stack<Pair> d = new Stack<>();
    static Stack<Pair> p = new Stack<>();
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        init(n, deliveries, pickups);
        
        return solve(cap);
    }
    
    void init(int n, int[] deliveries, int[] pickups) {
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0)
                d.push(new Pair(deliveries[i], i + 1));
            if (pickups[i] != 0)
                p.push(new Pair(pickups[i], i + 1));
        }
    }
    
    long solve(int cap) {
        long result = 0L;
        int pack;
        
        while (!d.isEmpty() || !p.isEmpty()) {
            int tempD = 0, tempP = 0;
            
            // 배달
            pack = cap;
            while (pack > 0 && !d.isEmpty()) {
                Pair pair = d.pop();
                tempD = Math.max(tempD, pair.distance);
                if (pack >= pair.value)
                    pack-= pair.value;
                else {
                    pair.value -= pack;
                    pack = 0;
                    d.push(pair);
                }
            }
            
            // 회수
            pack = 0;
            while (pack < cap && !p.isEmpty()) {
                Pair pair = p.pop();
                tempP = Math.max(tempP, pair.distance);
                if (pack + pair.value <= cap)
                    pack += pair.value;
                else {
                    pair.value -= cap - pack;
                    pack = cap;
                    p.push(pair);
                }
            }
            
            // 거리 계산
            result += tempD > tempP ? 2 * tempD : 2 * tempP;
        }
        
        return result;
    }
    
    static class Pair {
        int value;
        int distance;
        
        public Pair(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }
    }
}