import java.io.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=0;i<N-1;i++){
            answer += Integer.parseInt(br.readLine())-1;
        }

        answer += Integer.parseInt(br.readLine());

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}