import java.io.*;
import java.util.*;

class Main{

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < N ; i++) {
            if(i%2 == 0) {
                sb.append('*');
            }
            else {
                sb.append(' ');
            }
        }
        sb.append('\n');

        for(int i = 0; i < N ; i++) {
            if(i%2!=0) {
                sb.append('*');
            }
            else {
                sb.append(' ');
            }
        }
        sb.append('\n');


        String str = sb.toString();

        for(int i = 1; i < N ; i++) {
            sb.append(str);
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

