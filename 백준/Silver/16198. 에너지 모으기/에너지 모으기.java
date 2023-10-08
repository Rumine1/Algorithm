import java.io.*;
import java.util.*;

class Main{
    private int N;
    private int[] bead;
    private int maxValue;
    private boolean[] visited;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        bead = new int[N];
        visited = new boolean[N];

        for(int i=0;i<N;i++){
            bead[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(maxValue);
    }

    public void dfs(int depth, int current){
        if(depth>=N-2){
            maxValue = Math.max(maxValue, current);
            return;
        }

        for(int i=1;i<N-1;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, current+addCurrent(i));
                visited[i] = false;
            }
        }
    }

    public int addCurrent(int idx){
        int temp1 = 0;
        int temp2 = 0;
        for(int i=idx-1;i>=0;i--){
            if(!visited[i]){
                temp1 = bead[i];
                break;
            }
        }

        for(int i=idx+1;i<N;i++){
            if(!visited[i]){
                temp2 = bead[i];
                break;
            }
        }

        return (temp1*temp2);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}