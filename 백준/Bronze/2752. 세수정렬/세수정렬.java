import java.io.*;
import java.util.*;

class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[3];
        for(int i=0;i<3;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3-i-1;j++){
                if(num[j]>num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }

        for(int i=0;i<3;i++){
            System.out.print(num[i]+" ");
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}