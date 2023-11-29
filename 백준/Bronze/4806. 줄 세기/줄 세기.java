import java.io.*;
import java.util.*;

class Main{

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = "";
        int count = 0;
        while((line=br.readLine())!=null){
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

