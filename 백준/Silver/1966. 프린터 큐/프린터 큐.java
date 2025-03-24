import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, N, M, value, cnt;
    static Queue<Integer> q;

    // 우선 순위 큐는 작은 수를 먼저 반환하는 게 기본 세팅.
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            cnt = 0;
            q = new LinkedList<>();
            pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int document = Integer.parseInt(st.nextToken());
                q.add(document);
                pq.add(document);
                if (j == M) {
                    value = document;
                }
            }

            while (!q.isEmpty()) {
                Integer document = q.poll();
                M--;
                if (document != pq.peek()) {
                    if (M == -1) {
                        M = q.size();
                    }
                    q.add(document);
                } else {
                    pq.poll();
                    cnt++;
                    if (M == -1) {
                        System.out.println(cnt);
                        break;
                    }
                }
            }
        }
    }
}
