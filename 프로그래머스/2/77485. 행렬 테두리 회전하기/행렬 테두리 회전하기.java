import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows * columns; i++){
            int row = i / columns;
            int col = i % columns;
            matrix[row][col] = i + 1;
        }



        for (int[] query:queries) {
            int res = 99999999;
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            Deque<Integer> temp = new LinkedList<>();

            int dx = x2 - x1;
            int dy = y2 - y1;

            for (int i = 0; i < dy; i++) {
                temp.add(matrix[x1][y1 + i]);
                res = (res > matrix[x1][y1 + i]) ? matrix[x1][y1 + i] : res;
            }
            for (int i = 0; i < dx; i++) {
                temp.add(matrix[x1 + i][y2]);
                res = (res > matrix[x1 + i][y2]) ? matrix[x1 + i][y2] : res;
            }
            for (int i = 0; i < dy; i++) {
                temp.add(matrix[x2][y2 - i]);
                res = (res > matrix[x2][y2 - i]) ? matrix[x2][y2 - i] : res;
            }
            for (int i = 0; i < dx; i++) {
                temp.add(matrix[x2 - i][y1]);
                res = (res > matrix[x2 - i][y1]) ? matrix[x2 - i][y1] : res;
            }
            
            for (int i = 1; i <= dy; i++) {
                matrix[x1][y1 + i] = temp.poll();
            }
            for (int i = 1; i <= dx; i++) {
                matrix[x1 + i][y2] = temp.poll();
            }
            for (int i = 1; i <= dy; i++) {
                matrix[x2][y2 - i] = temp.poll();
            }
            for (int i = 1; i<= dx; i++) {
                matrix[x2 - i][y1] = temp.poll();
            }

            // for (int i = 0; i < rows; i++) {
            //     for (int j = 0; j < columns; j++) {
            //         System.out.print(matrix[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            
            answer = Arrays.copyOf(answer, answer.length + 1); // 배열 크기 늘리기
            answer[answer.length - 1] = res;
        }

        return answer;
    }
}