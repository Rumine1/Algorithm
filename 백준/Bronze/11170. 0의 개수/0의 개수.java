import java.io.*;
import java.util.*;

class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int count = 0;

            for(int j=N;j<=M;j++){
                int num = j;
                if(num==0){
                    count++;
                    continue;
                }

                while(num>1){
                    if(num%10==0){
                        count++;
                    }
                    num/=10;
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}