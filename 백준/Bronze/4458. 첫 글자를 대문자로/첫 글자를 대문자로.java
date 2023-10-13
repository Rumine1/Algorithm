import java.io.*;
import java.util.*;

class Main{
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            sb.append((str.charAt(0) + "").toUpperCase() + str.substring(1, str.length())).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}