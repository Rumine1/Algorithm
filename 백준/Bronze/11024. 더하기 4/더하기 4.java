import java.io.*;
import java.util.*;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            while(st.hasMoreTokens()){
                sum += Integer.parseInt(st.nextToken());
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

