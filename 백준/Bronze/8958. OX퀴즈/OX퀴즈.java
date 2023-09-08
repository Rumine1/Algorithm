import java.io.*;
import java.util.*;

class Main{
    private void solution()  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String s = br.readLine();
            int before=0;
            int sum = 0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='O'){
                    before += 1;
                    sum += before;
                }else{
                    before=0;
                }
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}


