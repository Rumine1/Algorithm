import java.io.*;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n-i; j++) {
                sb.append(" ");
            }
            for (int k=1; k<=2*i-1; k++) {
                if (k%2 == 1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }


        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
