import java.io.*;

class Main{
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            String number = br.readLine();
            sb.append((number.charAt(number.length()-1)-'0')%2==0?"even":"odd");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}