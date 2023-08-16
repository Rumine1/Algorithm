import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main{
    private int N;
    private int M;
    private int[][] paper;
    private boolean[][] visited;
    private int maxValue;

    public void solution()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        visited = new boolean[N][M];

        StringBuilder sb;
        for(int i = 0;i<N;i++){
            sb = new StringBuilder(br.readLine());
            for(int j = 0;j<M;j++){
                paper[i][j] = sb.charAt(j)-'0';
            }
        }

        dfs(0, 0, 0);
        System.out.println(maxValue);
    }

    private void dfs(int idx, int start1, int start2){
        if(idx == N*M){
            calc();
            return;
        }

        for(int i = start1;i<N;i++){
            for(int j = start2 ; j<M;j++){
                visited[i][j]=true;
                dfs(idx+1,j+1==M?i+1:i,(j+1)%M);
                visited[i][j]=false;
                dfs(idx+1,j+1==M?i+1:i,(j+1)%M);
                }
            }
        }

    private void calc(){
        int value=0;
        int tempMax = 0;
        for(int i =0;i<N;i++){
            for(int j = 0;j<M;j++){
                if(visited[i][j]){
                    value = value * 10 + paper[i][j];
                }
                if(!visited[i][j]||j==M-1){
                    tempMax += value;
                    value = 0;
                }
            }
        }

        for(int i = 0;i<M;i++){
            for(int j =0;j<N;j++){
                if(!visited[j][i]){
                    value = value * 10 + paper[j][i];
                }
                if(visited[j][i]||j==N-1){
                    tempMax += value;
                    value = 0;
                }
            }
        }
        maxValue = Math.max(maxValue, tempMax);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
