import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int callTime = 0;
        int human1 = 0;
        int human2 = 0;

        for(int i=0;i<N;i++){
            callTime = Integer.parseInt(st.nextToken());

            int temp1 = callTime/30;

            int temp2 = callTime/60;


            human1 += 10 * (temp1+1);

            human2 += 15 * (temp2+1);

        }

        if(human1>human2){
            sb.append("M "+human2);
        }else if(human1==human2){
            sb.append("Y M "+human1);
        }else{
            sb.append("Y "+human1);
        }


        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
