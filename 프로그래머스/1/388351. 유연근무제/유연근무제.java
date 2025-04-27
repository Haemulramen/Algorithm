class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            if (solve(schedules[i], timelogs[i], startday)) answer++;
        }
        
        return answer;
    }
    
    private boolean solve(int schedule, int[] timelog, int startday) {
        for (int i = 0; i < 7; i++) {
            int today = (i + startday) % 7;
            if (today == 0 || today == 6) continue;
            
            int time = timeToInt(timelog[i]);
            int scheduleTime = timeToInt(schedule + 10);
            if (time > scheduleTime) return false;
        }
        
        return true;
    }
    
    private int timeToInt(int time) {
        return time / 100 * 60 + time % 100;
    }
}