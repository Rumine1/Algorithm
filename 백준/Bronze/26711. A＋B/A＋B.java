import java.io.*;
import java.math.BigInteger;

class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());
        System.out.print(A.add(B));
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}