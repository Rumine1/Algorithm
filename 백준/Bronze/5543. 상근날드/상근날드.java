import java.io.*;
import java.util.*;

class Main{
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] menu = new int[5];
        for(int i=0;i<5;i++){
            menu[i] = Integer.parseInt(br.readLine());
        }

        int maxbur = Math.min(Math.min(menu[0],menu[1]),Math.min(menu[1], menu[2]));
        int maxdrink = Math.min(menu[3], menu[4]);

        System.out.println(maxbur+maxdrink-50);
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}