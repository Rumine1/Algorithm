import java.io.*;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                sb.append(" ");
            }

            sb.append("*");

            for (int j = 0; j < 2 * i - 1; j++) {
                sb.append(" ");
            }

            if (i > 0)
                sb.append("*");

            sb.append("\n");
        }


        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
