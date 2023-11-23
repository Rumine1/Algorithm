import java.io.*;
import java.util.*;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int min = 1000000;
            int max = -1000000;
            for(int j=0;j<N;j++){
                int num =  Integer.parseInt(st.nextToken());
                 min = Math.min(min, num);
                 max = Math.max(max, num);
            }
            sb.append(min+" ");
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

