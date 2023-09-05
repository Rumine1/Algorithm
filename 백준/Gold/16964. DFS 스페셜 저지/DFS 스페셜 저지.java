import java.io.*;
import java.util.*;

class Main{
    private int N;
    private ArrayList<Integer>[] list;
    private int[] example;
    private boolean[] visited;
    private int[] parent;
    private int count=0;
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            list[a].add(b);
            list[b].add(a);
        }

        //문제로 주어진 탐색 순서
        example = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            example[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        visited = new boolean[N];

        if(example[0]!= 0){
            System.out.println(0);
            System.exit(0);
        }

        parent = new int[N];

        Dfs(0, 0);
        System.out.println(1);

    }

    private void Dfs(int current, int index) {
        visited[current] = true;
        int count = 0;
        for(int temp:list[current]){
            if(!visited[temp] ){
                visited[temp] = true;
                parent[temp] = current;
                count++;
            }
        }
        index++;

        for(int i=0;i<count;i++){
            int node = example[index];
            if(parent[node]!=current){
                System.out.println(0);
                System.exit(0);
            }
            Dfs(node, index);
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}