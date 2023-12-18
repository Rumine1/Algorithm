import java.io.*;
import java.math.BigInteger;

class Main{

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(br.readLine());
        String oper = br.readLine();
        BigInteger b = new BigInteger(br.readLine());

        switch(oper){
            case "+":
                System.out.println(a.add(b));
                break;
            case "*":
                System.out.println(a.multiply(b));
                break;

        }

    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
