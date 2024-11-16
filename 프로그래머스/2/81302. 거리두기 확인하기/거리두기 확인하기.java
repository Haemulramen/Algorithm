import java.util.*;

class Solution {
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static char[][] map;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
    
        int i = 0;
        for(String[] place : places) {
            answer[i] = check(place);
            i++;
        }
        
        return answer;
    }
    
    class Position {
        public int x;
        public int y;
        
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int check(String[] place) {
        map = new char[5][5];
        
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = place[i].charAt(j);
            }
        }
        
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P') {
                    if (bfs(i, j)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
    
    public boolean bfs(int x, int y) {
        Queue<Position> q = new LinkedList<>();
        int[][] depth = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j< 5; j++) {
                depth[i][j] = -1;
            }
        }
        
        q.add(new Position(x, y));
        depth[x][y] = 0;
        
        while(!q.isEmpty()) {
            Position cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                    continue;
                }
                
                if (map[nx][ny] != 'X' && depth[nx][ny] == -1) {
                    depth[nx][ny] = depth[cur.x][cur.y] + 1;
                    if (map[nx][ny] == 'P' && depth[nx][ny] <= 2) {
                        return true;
                    }
                    q.add(new Position(nx, ny));
                }
            }
        }
        return false;
    }
}