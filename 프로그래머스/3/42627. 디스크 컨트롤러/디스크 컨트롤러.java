import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int jobCount = jobs.length;
        int cnt = 0;
        int totalTime = 0;
        int jobIdx = 0;
        int curTime = 0;
        
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        while (cnt < jobCount) {
            while (jobIdx < jobCount && jobs[jobIdx][0] <= curTime) {
                pq.offer(jobs[jobIdx]);
                jobIdx++;
            }
            
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                int requestTime = job[0];
                int duration = job[1];
                
                curTime += duration;
                totalTime += (curTime - requestTime);
                cnt++;
            } else {
                if (jobIdx < jobCount) {
                    curTime = jobs[jobIdx][0];
                }
            }
        }
        
        return totalTime / jobCount;
    }
}