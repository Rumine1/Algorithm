import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main{

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        BigInteger zero = new BigInteger("0");

        if (a.compareTo(zero)==-1 && b.compareTo(zero)==-1 ) {
            BigInteger temp = a.divide(b).add(new BigInteger("1"));
            sb.append(temp).append("\n");
            sb.append(a.subtract(b.multiply(temp)));
        }else if(a.compareTo(zero)==-1){
            BigInteger temp = a.divide(b).subtract(new BigInteger("1"));
            sb.append(temp).append("\n");
            sb.append(a.subtract(b.multiply(temp)));
        }else{
            sb.append(a.divide(b)).append("\n");
            sb.append(a.remainder(b));
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

