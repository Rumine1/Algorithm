import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] arr = {a,b,c};
            Arrays.sort(arr);

            a = arr[0];
            b = arr[1];
            c = arr[2];
            
            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if(c*c == (a*a+b*b)){
                sb.append("right");
            }else{
                sb.append("wrong");
            }

            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}