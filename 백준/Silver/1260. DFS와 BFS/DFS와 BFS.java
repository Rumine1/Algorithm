import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


class Main{
    private int N;
    private int M;
    private int V;
    private List<Integer>[] node;
    private boolean[] visited;
    private ArrayList<Integer> queue;
    private void solution()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        node = new ArrayList[N+1];
        visited = new boolean[N+1];
        visited[0] = true;

        for(int i = 1;i<N+1;i++){
            node[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }

        for(int i =1;i<N+1;i++){
            node[i].sort(Comparator.naturalOrder());
        }

        dfs(V);
        visited = new boolean[N+1];
        visited[0] = true;
        queue = new ArrayList<Integer>();
        System.out.println();
        bfs(V);

    }

    private void dfs(int idx){
        visited[idx] = true;
        System.out.print(idx+" ");
        for(int curIdx:node[idx]){
            if(!visited[curIdx]){
                dfs(curIdx);
            }
        }
    }

    private void bfs(int idx){
        queue.add(idx);
        visited[idx] = true;

        while(!queue.isEmpty()){
            int index = queue.get(0);
            queue.remove(0);
            System.out.print(index+" ");
            for(int curIdx:node[index]){
                if (!visited[curIdx]){
                    visited[curIdx] = true;
                    queue.add(curIdx);
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}
