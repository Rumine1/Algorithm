import java.io.*;
import java.util.*;

class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        A = B - A;

        System.out.println(A +" "+ B);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}