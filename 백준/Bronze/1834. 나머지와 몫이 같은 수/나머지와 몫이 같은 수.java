import java.io.*;
import java.util.*;

class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());
        long sum = 0;

        for(long i =1;i<=N-1;i++){
            sum += (N*i) + i;
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}