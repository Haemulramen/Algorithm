class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[triangle[i].length];
        }
        
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            int size = triangle[i].length;
            for (int j = 0; j < size; j++) {
                int left = j - 1;
                int right = j;
                
                if (left >= 0) {
                    left = dp[i - 1][left];
                } else {
                    left = Integer.MIN_VALUE;
                }
                
                if (right < size - 1) {
                    right = dp[i - 1][right];
                } else {
                    right = Integer.MIN_VALUE;
                }
                
                dp[i][j] = triangle[i][j] + Math.max(left, right);
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < triangle[n - 1].length; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }
        
        return answer;
    }
}