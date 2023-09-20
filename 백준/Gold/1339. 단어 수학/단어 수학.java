import java.io.*;
import java.util.*;

class Main{
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb;

        int[] alpha = new int[26];
        for(int i=0;i<N;i++){
            sb = new StringBuilder(br.readLine());
            int temp = (int)Math.pow(10, sb.length()-1);
            for(int j=0;j<sb.length();j++){
                alpha[sb.charAt(j)-65] += temp;
                temp/=10;

            }
        }

        Arrays.sort(alpha);

        int sum=0;
        int index=9;
        for(int i=alpha.length-1;i>=0;i--){
            if(alpha[i]==0){
                break;
            }

            sum += alpha[i] * index;
            index--;
        }

        System.out.println(sum);
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}