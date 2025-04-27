import java.util.*;

class Solution {
    
    static int row, col, cnt = 1;
    
    static char[][] map;
    static char[][] temp;
    static int[][] dfsMap;
    
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        // 입력 사이즈
        row = storage.length;
        col = storage[0].length();
        
        // 초기 맵, 저장공간 초기화
        map = new char[row + 2][col + 2];
        temp = new char[row + 2][col + 2];
        dfsMap = new int[row + 2][col + 2];
        
        // 초기 맵 상태 입력 받기
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                map[i][j] = storage[i - 1].charAt(j - 1);
                temp[i][j] = map[i][j];
            }
        }
        
        for (String request : requests) {
            if (request.length() == 1) {
                jigae(request.charAt(0));
            } else {
                crain(request.charAt(0));
            }
            dfs(0, 0);
            cnt++;
        }
        
        return countContainer();
    }
    
    private void jigae(char ch) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (map[i][j] == ch && checkSide(i, j)) {
                    map[i][j] = '0';
                }
            }
        }
    }
        
    private void crain(char ch) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (map[i][j] == ch) {
                    map[i][j] = '0';
                }
            }
        }
    }
    
    private boolean checkSide(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (temp[nr][nc] == 0) return true;
        }
        
        return false;
    }
    
    private int countContainer() {
        int answer = 0;
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (map[i][j] != '0') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private void dfs(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr < 0 || nr > row + 1 || nc < 0 || nc > col + 1) continue;
            
            if (dfsMap[nr][nc] < cnt && (map[nr][nc] == '0' || temp[nr][nc] == 0)) {
                dfsMap[nr][nc] = cnt;
                temp[nr][nc] = 0;
                dfs(nr, nc);
            }
        }
    }
}
