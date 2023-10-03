import java.io.*;
import java.util.*;

class Main{
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while(!(s=br.readLine()).equals("0")){
            boolean check = false;
            for(int i=0;i<s.length()/2;i++){
                if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                    check = true;
                    break;
                }
            }

            if(check){
                System.out.println("no");
            }else{
                System.out.println("yes");
            }
        }
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}