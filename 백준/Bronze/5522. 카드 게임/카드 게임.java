import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum = 0;
        for(int i=0;i<5;i++){
            sum += Integer.parseInt(br.readLine());
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}