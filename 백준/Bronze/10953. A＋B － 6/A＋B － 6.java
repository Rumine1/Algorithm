import java.io.*;
import java.util.*;

class Main{
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), ",");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a+b).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}