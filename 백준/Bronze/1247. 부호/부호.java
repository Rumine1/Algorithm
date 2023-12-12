import java.io.*;
import java.math.BigInteger;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<3;i++){
            int testCase = Integer.parseInt(br.readLine());
            BigInteger sum = new BigInteger("0");

            for(int j=0;j<testCase;j++){
                sum = sum.add(new BigInteger(br.readLine()));
            }


            if(sum.compareTo(new BigInteger("0"))==0){
                sb.append(0);
            }else if(sum.compareTo(new BigInteger("0"))==-1){
                sb.append("-");
            }else{
                sb.append("+");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
