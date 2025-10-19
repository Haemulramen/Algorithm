class Solution {
    
    public int solution(int[][] sizes) {
        int answer = Integer.MAX_VALUE;
        int limit = 0;
        
        for (int[] size : sizes) {
            limit = Math.max(limit, size[0] > size[1] ? size[0] : size[1]);
        }
        
        for (int y = 1; y <= limit; y++) {
            for (int x = 1; x <= limit; x++) {
                boolean check = true;
                
                for (int[] size : sizes) {
                    if ((x < size[0] || y < size[1]) &&
                        (x < size[1] || y < size[0])){
                        check = false;
                        break;
                    }
                }
                
                if (check) {
                    answer = Math.min(answer, x * y);
                }
            }
        }
        return answer;
    }
}