import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A==0&&B==0){
                break;
            }

            if(A>B){
                sb.append("Yes").append("\n");
            }else{
                sb.append("No").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}