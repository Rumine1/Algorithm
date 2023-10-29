import java.io.*;

class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());
        long sum = 1;
        for(int i=0;i<N;i++){
            sum *= i+1;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}