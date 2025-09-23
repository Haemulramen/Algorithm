import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthKnownCount = Integer.parseInt(st.nextToken());
        // 진실을 아는 사람이 없으면 모든 파티에서 거짓말 가능
        if (truthKnownCount == 0) {
            System.out.println(M);
            return;
        }
        
        // 진실을 아는 사람들을 모두 0번 노드(진실의 근원)에 연결
        for (int i = 0; i < truthKnownCount; i++) {
            int person = Integer.parseInt(st.nextToken());
            union(0, person);
        }

        List<Integer>[] parties = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partySize; j++) {
                parties[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        
        // 모든 파티 정보를 M번 반복하며 union 연산을 수행하여 진실을 완전히 전파
        for (int k = 0; k < M; k++) {
            for (int i = 0; i < M; i++) {
                if (parties[i].size() > 1) {
                    int firstPerson = parties[i].get(0);
                    for (int j = 1; j < parties[i].size(); j++) {
                        union(firstPerson, parties[i].get(j));
                    }
                }
            }
        }


        int answer = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int person : parties[i]) {
                // 파티원 중 한 명이라도 진실을 아는 사람과 연결되어 있다면 거짓말 불가
                if (find(person) == find(0)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // 한 쪽이라도 진실을 알면(루트가 0이면) 다른 쪽도 진실을 아는 집합에 포함
            if (rootX == 0) {
                parent[rootY] = rootX;
            } else { // rootY가 0이거나 둘 다 0이 아닐 경우
                parent[rootX] = rootY;
            }
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}