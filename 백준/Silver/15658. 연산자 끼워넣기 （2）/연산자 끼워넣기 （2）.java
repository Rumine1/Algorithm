import java.io.*;
import java.util.*;

class Main{
    private int maxValue=Integer.MIN_VALUE;
    private int minValue=Integer.MAX_VALUE;

    private int N;
    private int[] operand;
    private int[] operator;


    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        operand = new int[N];
        operator = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            operand[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(operand[0], 1);
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    public void dfs(int current, int idx){
        if(idx>=N){
            maxValue = Math.max(maxValue, current);
            minValue = Math.min(minValue, current);
            return;
        }

        for(int i=0;i<4;i++){
            if(operator[i]==0){
                continue;
            }

            operator[i]--;

            switch(i){
                case 0:
                    dfs(current+operand[idx],idx+1);
                    break;
                case 1:
                    dfs(current-operand[idx],idx+1);
                    break;
                case 2:
                    dfs(current*operand[idx],idx+1);
                    break;
                case 3:
                    dfs(current/operand[idx],idx+1);
                    break;
            }

            operator[i]++;
        }


    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}