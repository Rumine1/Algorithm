import java.io.*;
import java.util.*;

class Main{
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num=0;
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            if(br.readLine().equals("0")){
                num++;
            }else{
                num--;
            }
        }
        System.out.println(num>0?"Junhee is not cute!":"Junhee is cute!");
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}