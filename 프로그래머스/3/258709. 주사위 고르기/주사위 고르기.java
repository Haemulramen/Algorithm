// import java.util.*;

// class Solution {
    
//     static int N, maxWin = 0;
//     static int[] mine, partner, answer;
    
//     public int[] solution(int[][] dice) {
//         N = dice.length;
//         answer = new int[N / 2];
//         mine = new int[100 * N / 2 + 1];
//         partner = new int[100 * N / 2 + 1];
        
//         diceCombination(dice, 0, new ArrayList<>());
        
//         return answer;
//     }
    
//     void diceCombination(int[][] dice, int cur, List<Integer> choice) {
//         if (choice.size() < N / 2) {
//             for (int i = cur; i < N; i++) {
//                 choice.add(i);
//                 diceCombination(dice, i + 1, choice);
//                 if (choice.size() != 0) choice.remove(choice.size() - 1);
//             }
//         }        
//         else {
//             Arrays.fill(mine, 0);
//             Arrays.fill(partner, 0);
            
//             int[][] myDice = new int[N / 2][6];
//             int[][] partnerDice = new int[N / 2][6];
//             int my = 0, you = 0;
//             for (int i = 0; i < N; i++) {
//                 if (choice.contains(i)) myDice[my] = dice[i];
//                 else partnerDice[you] = dice[i];
//             }
//             getPoint(mine, myDice, 0, new ArrayList<>());
//             getPoint(partner, partnerDice, 0, new ArrayList<>());
//             int temp = countWin();
//             if (maxWin < temp) {
//                 maxWin = temp;
//                 for (int i = 0; i < N / 2; i++) {
//                     answer[i] = choice.get(i) + 1;
//                 }
//                 System.out.println(Arrays.toString(answer));
//             }
//         }
//     }
    
//     void getPoint(int[] mem, int[][] dices, int cur, List<Integer> choice) {
//         // 주사위에서 숫자를 덜 고른 경우
//         if (choice.size() < N / 2) {
//             for (int i = 0; i < 6; i++) {
//                 choice.add(dices[cur][i]);
//                 getPoint(mem, dices, cur + 1, choice);
//                 if (choice.size() != 0) choice.remove(choice.size() - 1);
//             }
//         }
//         else {
//             // 고른 주사위 개수만큼 숫자를 선택한 경우
//             int total = calculate(choice);
//             mem[total]++;
//         }
//     }
    
//     int calculate(List<Integer> choice) {
//         int result = 0;
//         for (int num : choice) 
//             result += num;
//         return result;
//     }
    
//     int countWin() {
//         int win = 0;
        
//         for (int i = 1; i <= 100 * N / 2; i++) {
//             partner[i] += partner[i - 1];
//             win += mine[i] * partner[i - 1];
//         }
        
//         return win;
//     }
// }

import java.util.*;

class Solution {
    
    static int N, maxWin = 0;
    static int[] mine, partner, answer;
    
    public int[] solution(int[][] dice) {
        N = dice.length;
        mine = new int[100 * N / 2 + 1];
        partner = new int[100 * N / 2 + 1];
        answer = new int[N / 2];
        
        dfs(dice, 0, 0, new int[N / 2], new boolean[N]);
        
        return answer;
    }

    void dfs(int[][] dice, int idx, int start, int[] selected, boolean[] visited) {
        if (idx == N / 2) {
            Arrays.fill(mine, 0);
            Arrays.fill(partner, 0);

            int[][] myDice = new int[N / 2][6];
            int[][] oppDice = new int[N / 2][6];
            int myIdx = 0, oppIdx = 0;

            for (int i = 0; i < N; i++) {
                if (visited[i]) myDice[myIdx++] = dice[i];
                else oppDice[oppIdx++] = dice[i];
            }

            getPoint(mine, myDice, 0, 0);
            getPoint(partner, oppDice, 0, 0);

            int win = countWin();

            if (win > maxWin) {
                maxWin = win;
                for (int i = 0; i < N / 2; i++) {
                    answer[i] = selected[i] + 1;  // 주사위 번호는 1-based
                }
            }

            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[idx] = i;
                dfs(dice, idx + 1, i + 1, selected, visited);
                visited[i] = false;
            }
        }
    }

    void getPoint(int[] mem, int[][] dices, int depth, int sum) {
        if (depth == dices.length) {
            mem[sum]++;
            return;
        }

        for (int i = 0; i < 6; i++) {
            getPoint(mem, dices, depth + 1, sum + dices[depth][i]);
        }
    }

    int countWin() {
        int win = 0;
        for (int i = 1; i < mine.length; i++) {
            partner[i] += partner[i - 1];  // 누적합
            win += mine[i] * partner[i - 1];
        }
        return win;
    }
}
