import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] maze;
    static int[][] map;
    static int[] xpos = {1, 0, -1, 0};
    static int[] ypos = {0, 1, 0, -1};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        maze = new int[N][M];
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            String line = sc.nextLine();
            String[] split = line.split("");
            for(int j = 0; j < M; j++){
                maze[i][j] = Integer.parseInt(split[j]);
            }
        }

        q.add(new int[]{0, 0});
        map[0][0] = 1;
        find();
        System.out.println(map[N-1][M-1]);
    }

    private static void find() {
        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 4; i++) {
                if (current[0] + xpos[i] < 0 || current[0] + xpos[i] >= N ||
                        current[1] + ypos[i] < 0 || current[1] + ypos[i] >= M) {
                    continue;
                }
                if (maze[current[0] + xpos[i]][current[1] + ypos[i]] == 1 &&
                    map[current[0] + xpos[i]][current[1] + ypos[i]] == 0) {
                    map[current[0] + xpos[i]][current[1] + ypos[i]] = map[current[0]][current[1]] + 1;
                    q.add(new int[]{current[0] + xpos[i], current[1] + ypos[i]});
                }
            }
        }
    }
}
