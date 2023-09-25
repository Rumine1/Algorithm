import java.io.*;
import java.util.*;

class Main{
    private int N;
    private int[] S;
    private boolean[] visited;
    private boolean check;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        S = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            S[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[100000*20];
        dfs(0,0);

        for(int i=1;i<visited.length;i++){
            if(!visited[i]){
                System.out.println(i);
                break;
            }
        }

    }

    public void dfs(int depth, int sum){
        if(depth == N){
            visited[sum] = true;
            return;
        }

        dfs(depth+1, sum+S[depth]);
        dfs(depth+1, sum);
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}