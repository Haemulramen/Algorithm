import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<String> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String line = st.nextToken();
        String[] split = line.split("");
        int res = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("(")) {
                q.add(split[i]);
            } else if (split[i - 1].equals(")") && split[i].equals(")")) {
                q.poll();
                res += 1;
            } else {
                q.poll();
                res += q.size();
            }
        }
        System.out.println(res);
    }
}
