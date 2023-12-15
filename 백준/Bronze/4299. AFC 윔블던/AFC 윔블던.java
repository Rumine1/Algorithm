import java.io.*;
import java.util.*;

class Main{

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int sum = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());
        
        if(sum==0 && sub == 0){
            System.out.println(0+" "+0);
            return;
        }

        for(int i = sum/2;i<sum;i++){
            if(i - (sum - i) == sub){
                System.out.println(i + " " + (sum-i));
                return;
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
