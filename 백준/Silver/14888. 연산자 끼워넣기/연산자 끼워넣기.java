import java.io.*;
import java.util.*;

class Main{
    private int N;
    private int[] operand;
    private int[] operator;
    private int Max = Integer.MIN_VALUE;
    private int Min = Integer.MAX_VALUE;

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        operand = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            operand[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operator = new int[4];
        for(int i=0;i<4;i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }


        dfs(operand[0], 1);
        System.out.println(Max);
        System.out.println(Min);
    }

    public void dfs(int num, int idx){
        if(idx==N){
            Max = Math.max(Max, num);
            Min = Math.min(Min, num);
            return;
        }

        for(int i=0;i<4;i++){
            if(operator[i]==0){
                continue;
            }

            operator[i]--;

            switch(i){
                case 0:
                    dfs(num+operand[idx], idx+1);
                    break;
                case 1:
                    dfs(num-operand[idx], idx+1);
                    break;
                case 2:
                    dfs(num*operand[idx], idx+1);
                    break;
                case 3:
                    dfs(num/operand[idx], idx+1);
                    break;
            }

            operator[i]++;

        }
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}