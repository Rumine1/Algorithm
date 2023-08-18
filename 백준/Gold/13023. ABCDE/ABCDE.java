import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
    private int N;
    private int M;
    private List<Integer>[] list;
    private boolean[] visited;

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        visited = new boolean[N];

        for(int i =0;i<N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for(int i=0;i<N;i++){
            dfs(i,1);
        }
        System.out.println(0);

    }

    private void dfs(int idx, int depth){
        if(depth==5){
            System.out.println(1);
            System.exit(0);
        }

        visited[idx] = true;
        for(int currentLocation:list[idx]){
            if(!visited[currentLocation]){
                dfs(currentLocation, depth+1);
            }
        }
        visited[idx] = false;
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}