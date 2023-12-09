import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        StringBuilder sb = new StringBuilder();

        sb.append(n.divide(m)).append("\n");
        sb.append(n.remainder(m));

        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
