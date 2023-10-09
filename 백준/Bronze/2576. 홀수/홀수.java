import java.io.*;
import java.util.*;

class Main{
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int minValue = 100;
        for(int i=0;i<7;i++){
            int num = Integer.parseInt(br.readLine());
            if(num%2==1){
                sum += num;
                minValue = Math.min(minValue, num);
            }
        }

        if(minValue==100){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(minValue==100?-1:minValue);
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}