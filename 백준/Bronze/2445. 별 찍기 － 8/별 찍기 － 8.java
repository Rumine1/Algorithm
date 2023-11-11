import java.io.*;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                sb.append("*");
            }
            for (int k=1; k<=2*(n-i); k++) {
                sb.append(" ");
            }
            for (int j=1; j<=i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i=n-1; i>0; i--) {
            for (int j=1; j<=i; j++) {
                sb.append("*");
            }
            for (int k=1; k<=2*(n-i); k++) {
                sb.append(" ");
            }
            for (int j=1; j<=i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
