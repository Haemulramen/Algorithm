import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        
        System.out.println(a+b-c);
        System.out.println(Integer.parseInt("" + a + b) - c);
    }
}