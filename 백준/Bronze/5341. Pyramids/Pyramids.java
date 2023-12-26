import java.io.*;

public class Main {
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String str;
        while(!(str=br.readLine()).equals("0")){
            int num = Integer.parseInt(str);

            int sum = 0;
            for(int i=1;i<=num;i++){
                sum += i;
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }


    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

