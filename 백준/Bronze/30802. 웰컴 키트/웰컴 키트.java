import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] shirts = new int[6];
        for (int i = 0; i < 6; i++) {
            shirts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int shirtCount = 0;
        for (int i = 0; i < 6; i++) {
            shirtCount += shirts[i] / t;
            if (shirts[i] % t != 0) {
                shirtCount++;
            }
        }
        System.out.println(shirtCount);

        System.out.println(n / p + " " + n % p);
    }
}
