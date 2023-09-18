import java.io.*;
import java.util.*;

class Main{
    class Node{
        int node;
        int cost;
        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    private int distance;
    private int node;
    private boolean[] visited;
    private ArrayList<Node>[] list;
    public void solution()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];

        for(int i=0;i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while(true){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == -1){
                    break;
                }
                list[num].add(new Node(temp, Integer.parseInt(st.nextToken())));
            }
        }

        visited = new boolean[N+1];
        dfs(1, 0);

        visited = new boolean[N+1];
        dfs(node, 0);

        System.out.println(distance);
    }

    public void dfs(int num, int len){
        if(distance < len){
            distance = len;
            node = num;
        }

        visited[num] = true;
        for(Node current:list[num]){
            if(!visited[current.node]){
                dfs(current.node, len+current.cost);
            }
        }
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}