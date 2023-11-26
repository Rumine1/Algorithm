import java.io.*;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(true){
            int temp = Integer.parseInt(br.readLine());
            if(temp==0){break;}

            sb.append(temp+" ");


            if(temp%n==0){
                sb.append("is a multiple of "+n);
            }else{
                sb.append("is NOT a multiple of "+n);
            }

            sb.append(".").append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

