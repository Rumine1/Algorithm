import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    private int N;
    private int M;
    private boolean[][] mat;
    private boolean[] visited;
    private int check;
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mat = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        visited[0] = true;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            mat[a][b] = true;
            mat[b][a] = true;
        }

        int count = 0;
        for(int i =1;i<N+1;i++){
            if(!visited[i]){
                Dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private void Dfs(int idx){
        visited[idx] = true;
        for(int i=1;i<N+1;i++){
            if(mat[idx][i] && !visited[i]){
                Dfs(i);
            }
        }
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}
