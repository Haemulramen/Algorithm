import java.util.*;

class Solution {
    
    static int coin, cur, n;
    static Set<Integer> mine, temp;
    static boolean[] check;
    
    public int solution(int c, int[] cards) {
        int answer = 1;
        init(c, cards);
        
        for (int i = cur; i < n; i += 2) {
            if (solve(i, cards)) {
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
    
    void init(int c, int[] cards) {
        coin = c;
        n = cards.length;
        check = new boolean[n + 1];
        cur = n / 3;
        mine = new HashSet<>();
        temp = new HashSet<>();
        for (int i = 0; i < cur; i++) {
            mine.add(cards[i]);
        }
    }
    
    boolean solve(int pos, int[] cards) {
        temp.add(cards[pos]);
        temp.add(cards[pos + 1]);
        
        for (int num : mine) {
            if (!check[num] && mine.contains(n + 1 - num)) {
                check[num] = true;
                check[n + 1 - num] = true;
                return true;
            }
        }
        
        for (int num : mine) {
            if (coin > 0 && !check[num] && temp.contains(n + 1 - num)) {
                check[num] = true;
                coin--;
                return true;
            }
        }
        
        for (int num : temp) {
            if (coin > 1 && !check[num] && temp.contains(n + 1 - num)) {
                check[num] = true;
                check[n + 1 - num] = true;
                coin -= 2;
                return true;
            }
        }
        
        return false;
    }
}