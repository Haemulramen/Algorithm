//오리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] quack = new int[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sound = br.readLine().split("");

        count_duck(sound);
    }

    static void count_duck(String[] sound) {
        int l = sound.length;
        if (l % 5 != 0) {
            System.out.println(-1);
            return;
        }
        int cnt = 0;

        for (int i = 0; i < l; i++) {
            if (sound[i].equals("q")) {
                quack[0]++;
            } else if (sound[i].equals("u")) {
                quack[1]++;
                if (quack[0] < quack[1]) {
                    System.out.println(-1);
                    return;
                }
            } else if (sound[i].equals("a")) {
                quack[2]++;
                if (quack[1] < quack[2]) {
                    System.out.println(-1);
                    return;
                }
            } else if (sound[i].equals("c")) {
                quack[3]++;
                if (quack[2] < quack[3]) {
                    System.out.println(-1);
                    return;
                }
            } else if (sound[i].equals("k")) {
                quack[4]++;
                if (quack[3] < quack[4]) {
                    System.out.println(-1);
                    return;
                }
                for (int j = 0; j < 5; j++) {
                    quack[j]--;
                }
            }

            int temp = quack[0];
            if (cnt < temp) {
                cnt = temp;
            }
        }
        if (quack[0] == quack[1] && quack[1] == quack[2] && quack[2] == quack[3] && quack[3] == quack[4]) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }
}
