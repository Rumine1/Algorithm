import java.io.*;
import java.util.*;

class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] apart = new int[15][15];
        for(int i=0;i<15;i++){
            apart[0][i] = i;
        }

        for(int i=1;i<15;i++){
            apart[i][0] = apart[i-1][0];
            for(int j=1;j<15;j++){
                apart[i][j] = apart[i][j-1] + apart[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(apart[k][n]+"\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}