import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        if(num==0){
            System.out.println("YONSEI");
        }else{
            System.out.println("Leading the Way to the Future");
        }


    }


    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

