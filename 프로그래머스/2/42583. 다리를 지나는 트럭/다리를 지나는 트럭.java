import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int num = truck_weights.length;
        int curWeight = 0;
        int curIdx = 0;
        int curTime = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length - 1; i++) bridge.offer(0);
        
        bridge.offer(truck_weights[0]);
        curWeight += truck_weights[0];
        curIdx = 1;
        curTime = 1;
        
        while (curWeight != 0) {
            curTime++;
            
            int out = bridge.poll();
            curWeight -= out;
            
            if (curIdx >= num) continue;
            
            if (curWeight + truck_weights[curIdx] <= weight) {
                bridge.offer(truck_weights[curIdx]);
                curWeight += truck_weights[curIdx++];
            } else {
                bridge.offer(0);
            }
        }
        
        return curTime;
    }
}