//숨바꼭질3

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int start, end;
    static Map<Integer, Integer> mem = new HashMap<>();
    static ArrayDeque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(" ");
        start = Integer.parseInt(split[0]);
        end = Integer.parseInt(split[1]);

        //여기부터 0/1 BFS 시작
        int level = 0;
        mem.put(start, level);
        q.add(start);
        while (!q.isEmpty()) {
            Integer now = q.poll();
            level = mem.get(now);
            if (now == end) {
                System.out.println(level);
                break;
            }
            if (now == 0) {
                if (mem.get(now + 1) == null) {
                    q.addLast(now + 1);
                    mem.put(now + 1, level + 1);
                } else {
                    continue;
                }
            }
            if (now < end) {
                q.addFirst(now * 2);
                mem.put(now * 2, level);

                if (mem.get(now + 1) == null) {
                    q.addLast(now + 1);
                    mem.put(now + 1, level + 1);
                }
            }
            if (mem.get(now - 1) == null) {
                q.addLast(now - 1);
                mem.put(now - 1, level + 1);
            }
        }
    }
}
