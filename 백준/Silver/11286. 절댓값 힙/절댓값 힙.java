import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class QueueComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>(1, new QueueComparator());
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int input = scanner.nextInt();
            if (input != 0) {
                q.add(input);
            } else {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
