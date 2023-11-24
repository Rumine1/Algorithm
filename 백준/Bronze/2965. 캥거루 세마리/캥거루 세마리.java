import java.io.*;
import java.util.*;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int num1 = b-a;
        int num2 = c-b;

        System.out.println(num1>num2?num1-1:num2-1);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

