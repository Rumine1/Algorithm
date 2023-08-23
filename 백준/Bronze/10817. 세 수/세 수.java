import java.io.*;
import java.util.StringTokenizer;

class Main{
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] number = {A,B,C};

        for(int i=0;i<3;i++){
            int temp = 0;
            for(int j=1;j<3-i;j++){
                if(number[j-1]>number[j]){
                    temp = number[j];
                    number[j] = number[j-1];
                    number[j-1] = temp;
                }
            }
        }
        System.out.println(number[1]);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}