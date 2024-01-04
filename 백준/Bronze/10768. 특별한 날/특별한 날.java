import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());

        if(month<2){
            System.out.println("Before");
        }else if(month>2){
            System.out.println("After");
        }else{
            if(day<18){
                System.out.println("Before");
            }else if(day>18){
                System.out.println("After");
            }else{
                System.out.println("Special");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

