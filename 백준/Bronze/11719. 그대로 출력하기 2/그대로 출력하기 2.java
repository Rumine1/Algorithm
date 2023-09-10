import java.io.*;

class Main{
    private void solution()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null){
            System.out.println(s);
        }
    }
    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}