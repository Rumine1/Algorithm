import java.io.*;
import java.util.*;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            sb.append("Pairs for ").append(n+": ");
            for(int j=1;j<=n/2;j++){
                if(j==n-j){
                    break;
                }

                if(j>1){
                    sb.append(", ");
                }

                sb.append(j).append(" ").append(n-j);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

