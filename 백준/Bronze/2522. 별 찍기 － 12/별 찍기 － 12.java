import java.io.*;
import java.util.*;

class Main{
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<2*N-1;i++){
            for(int j=0;j<Math.abs(N-i-1);j++){
                sb.append(" ");
            }

            for(int j=N;j>Math.abs(N-i-1);j--){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}


