//달팽이

import java.util.Scanner;

public class Main {

    static int N, num;
    //위쪽, 오른쪽, 아래쪽, 왼쪽 순서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = sc.nextInt();

        draw();
    }

    static void draw() {
        int[][] map = new int[N][N];
        int nx = N / 2;
        int ny = N / 2;
        map[nx][ny] = 1;
        //loop: 동글뱅이를 그릴 떄 상하좌우로 이동해야 하는 횟수
        //cnt: 한 방향으로 이동한 횟수
        //dir: 이동 방향
        int loop = 1, cnt = 0, dir = 0;
        for (int i = 1; i < N * N; i++) {
            nx += dx[dir % 4];
            ny += dy[dir % 4];
            map[nx][ny] = i + 1;

            cnt++;
            //진행해야 하는 횟수만큼 해당 방향으로 진행을 끝냄 -> 방향 바꾸기
            if (cnt == loop) {
                dir++;
            }
            //한 방향 진행 횟수를 늘릴 타이밍 -> loop 증가시켜서 진행 횟수 늘림, 방향 바꾸기, cnt 초기화
            if (cnt == loop * 2) {
                loop++;
                dir++;
                cnt = 0;
            }
        }

        int res_x = 0, res_y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
                if (map[i][j] == num) {
                    res_x = i + 1;
                    res_y = j + 1;
                }
            }
            System.out.println();
        }
        System.out.println(res_x + " " + res_y);
    }
}
