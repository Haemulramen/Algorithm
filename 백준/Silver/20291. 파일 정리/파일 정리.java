// 파일 정리

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        TreeMap<String, Integer> file = new TreeMap<>();
        String name;
        for (int i = 0; i < n; i++) {
            name = sc.nextLine();
            int idx = name.lastIndexOf(".");
            name = name.substring(idx + 1);
            if (file.get(name) == null) {
                file.put(name, 1);
            } else {
                file.put(name, file.get(name) + 1);
            }
        }

        for (String i : file.keySet()) {
            System.out.println(i + " " + file.get(i));
        }
    }
}
