//봄버맨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Supplier;

public class Main {

    static int R, C, N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        //폭탄 설치 위치를 저장할 points
        List<Point> points = new ArrayList<>();
        char[][] map = new char[R][];

        //시간에 맞는 함수를 호출하기 위한 함수 매핑
        Map<Integer, Supplier> actions = new HashMap<>();
        actions.put(0, () -> print(map));
        actions.put(1, () -> print1(points));
        actions.put(2, () -> print2());
        actions.put(3, () -> print3(points));

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    points.add(new Point(i, j));
                }
            }
        }

        char[][] res = new char[R][C];
        if (N == 0 || N == 1) {
            res = (char[][]) actions.get(0).get();
        } else if (N % 4 == 1) {
            res = (char[][]) actions.get(1).get();
        } else if (N % 2 == 0) {
            res = (char[][]) actions.get(2).get();
        } else if (N % 4 == 3) {
            res = (char[][]) actions.get(3).get();
        }

        for (int i = 0; i < R; i++) {
            System.out.println(res[i]);
        }
    }

    //x, y 좌표값을 저장할 클래스
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //N == 0 || N == 1인 경우
    static char[][] print(char[][] map) {
        return map;
    }

    //N > 1 && N % 4 == 1인 경우
    static char[][] print1(List<Point> points) {
        char[][] map = print3(points);
        points.clear();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    points.add(new Point(i, j));
                }
            }
        }
        return print3(points);
    }

    //N이 짝수인 경우
    static char[][] print2() {
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = 'O';
            }
        }
        return map;
    }

    //N % 4 == 3인 경우
    static char[][] print3(List<Point> points) {
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = 'O';
            }
        }
        //상하좌우 폭발
        for (Point point : points) {
            map[point.x][point.y] = '.';
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }
                map[nx][ny] = '.';
            }
        }
        return map;
    }
}