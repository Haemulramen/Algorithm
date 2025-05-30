import java.util.*;

class Solution {
    
    static int[] counts;
    static int n, playTime, advTime;
    
    public String solution(String play_time, String adv_time, String[] logs) {
        init(play_time, adv_time, logs);
        
        return solve();
    }
    
    int timeToInt(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]) * 60 * 60;
        int minute = Integer.parseInt(split[1]) * 60;
        int second = Integer.parseInt(split[2]);
        
        return hour + minute + second;
    }
    
    String intToTime(int time) {
        String second = String.format("%02d", time % 60);
        time /= 60;
        String minute = String.format("%02d", time % 60);
        time /= 60;
        String hour = String.format("%02d", time);
        
        return hour + ":" + minute + ":" + second;
    }
    
    void init(String play_time, String adv_time, String[] logs) {
        playTime = timeToInt(play_time);
        advTime = timeToInt(adv_time);
        
        counts = new int[playTime + 1];
        n = logs.length;
        for (int i = 0; i < n; i++) {
            String[] split = logs[i].split("-");
            int start = timeToInt(split[0]);
            int end = timeToInt(split[1]);
            counts[start]++;
            counts[end]--;
        }
    }
    
    String solve() {
        int pos = 0;
        int[] cur = new int[playTime + 1];
        
        long total = 0L, temp = 0L;
        temp = cur[0] = counts[0];
        
        for (int i = 1; i < advTime; i++) {
            cur[i] = cur[i - 1] + counts[i];
            temp += cur[i];
        }
        total = temp;
        
        for (int i = advTime; i < playTime; i++) {
            cur[i] = cur[i - 1] + counts[i];
            temp += cur[i] - cur[i - advTime];
            if (total < temp) {
                total = temp;
                pos = i - advTime + 1;
            }
        }
        
        System.out.println("total time: " + total);
        return intToTime(pos);
    }
}