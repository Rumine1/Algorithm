import java.io.*;
import java.util.*;

class Main{
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String date = br.readLine();

        st = new StringTokenizer(br.readLine());
        int count = 0;

        String s;
        for(int i=0;i<5;i++){
            if(st.nextToken().equals(date)){
                count++;
            }
        }

        System.out.println(count);

    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}