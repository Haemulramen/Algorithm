class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt_max = 0;
        int cnt_min = 0;
        for (int i = 0; i < 6; i++) {
            if (lottos[i] != 0) {
                for (int j = 0; j < 6; j++) {
                    if (lottos[i] == win_nums[j]) {
                        cnt_max++;
                        cnt_min++;
                    }
                }
            } else if (lottos[i] == 0) {
                cnt_max++;
            }
        }
        cnt_max = (cnt_max == 0) ? 1 : cnt_max;
        cnt_min = (cnt_min == 0) ? 1 : cnt_min;
        int[] answer = {7 - cnt_max, 7 - cnt_min};
        return answer;
    }
}