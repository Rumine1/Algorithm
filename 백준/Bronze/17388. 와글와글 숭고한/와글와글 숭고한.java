import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        if(S+K+H>=100){
            System.out.println("OK");
        }else{
            if(S>K){
                System.out.println(K>H?"Hanyang":"Korea");
            }else{
                System.out.println(S>H?"Hanyang":"Soongsil");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

