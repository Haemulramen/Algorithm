class Solution {
    
    static int max, profit, emoticonNum, userNum;
    static int[] cost;
    
    public int[] solution(int[][] users, int[] emoticons) {
        init(users, emoticons);
        
        dfs(0, users, emoticons);
        return new int[]{max, profit};
    }
    
    void init(int[][] users, int[] emoticons) {
        max = Integer.MIN_VALUE;
        profit = 0;
        emoticonNum = emoticons.length;
        userNum = users.length;
        cost = new int[emoticonNum];
    }
    
    void dfs(int pos, int[][] users, int[] emoticons) {
        if (pos == emoticonNum) {  // 모든 이모티콘의 할인율이 설정되었을 때만
            solve(users, emoticons);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            cost[pos] = i * 10;  // 10%, 20%, 30%, 40% 할인
            dfs(pos + 1, users, emoticons);
        }
    }
    
    void solve(int[][] users, int[] emoticons) {
        int plusCnt = 0, totalBuy = 0;
        
        for (int i = 0; i < userNum; i++) {
            int[] user = users[i];
            int buy = 0;
            for (int j = 0; j < emoticonNum; j++) {
                if (user[0] <= cost[j]) {
                    buy += emoticons[j] * (100 - cost[j]) * 0.01;
                }
            }
            
            if (buy >= user[1]) {
                plusCnt++;
            } else {
                totalBuy += buy;
            }
        }
        
        if (max < plusCnt) {
            max = plusCnt;
            profit = totalBuy;
        } else if (max == plusCnt) {
            profit = Math.max(profit, totalBuy);
        }
    }
}