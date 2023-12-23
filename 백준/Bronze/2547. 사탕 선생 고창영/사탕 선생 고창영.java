import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++){
            br.readLine();

            BigInteger sum = new BigInteger("0");

            int N = Integer.parseInt(br.readLine());
            for(int j=0;j<N;j++){
                sum = sum.add(new BigInteger(br.readLine()));
            }

            sum = sum.remainder(new BigInteger(Integer.toString(N)));
            int result = Integer.parseInt(sum.toString());
            sb.append(result==0?"YES":"NO");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}