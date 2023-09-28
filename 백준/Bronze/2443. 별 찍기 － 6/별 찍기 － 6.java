import java.io.*;
import java.util.*;

class Main{
    public void solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=N;i++){
            for(int j=1;j<i;j++){
                sb.append(" ");
            }
            for(int j=0;j<2*(N-i)+1;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}