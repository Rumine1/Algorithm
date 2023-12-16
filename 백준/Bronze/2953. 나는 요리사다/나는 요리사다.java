import java.io.*;
import java.util.*;

class Main{

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int person = 0;
        int answer = 0;
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());

            int sum = 0;

            for(int j=0;j<4;j++){
                sum += Integer.parseInt(st.nextToken());
            }

            if(answer < sum){
                answer = sum;
                person = i+1;
            }
        }

        System.out.println(person + " " + answer);


    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
