import java.io.*;
import java.util.*;

class Main{
    class Node{
        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
        private int node;
        private int cost;
    }
    private ArrayList<Node>[] list;
    private int maxLen;
    private int node;
    private boolean[] visited;
    public void solution()throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, cost));
            list[b].add(new Node(a, cost));
        }

        visited = new boolean[N+1];
        dfs(1, 0);
        visited = new boolean[N+1];
        dfs(node, 0);

        System.out.println(maxLen);
    }

    public void dfs(int curNode, int len){
        if(maxLen < len){
            maxLen = len;
            node = curNode;
        }

        visited[curNode] = true;
        for(Node tempNode:list[curNode]){
            if(!visited[tempNode.node]){
                dfs(tempNode.node, len+ tempNode.cost);
            }
        }
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}