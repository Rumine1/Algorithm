import java.io.*;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char word = br.readLine().charAt(0);

        if(word == 'N'||word == 'n'){
            System.out.println("Naver D2");
        }else{
            System.out.println("Naver Whale");
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
