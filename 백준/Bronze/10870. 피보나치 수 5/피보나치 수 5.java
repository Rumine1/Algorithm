import java.io.*;
import java.util.*;

class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[21];
        seq[0] = 0;
        seq[1] = 1;

        for(int i=2;i<=N;i++){
            seq[i] = seq[i-1] + seq[i-2];
        }

        System.out.println(seq[N]);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}