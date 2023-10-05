import java.io.*;
import java.util.*;

class Main{
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<5;i++){
            int num = (int)Math.pow(Integer.parseInt(st.nextToken()), 2);
            sum += num;
        }

        System.out.println(sum%10);
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}