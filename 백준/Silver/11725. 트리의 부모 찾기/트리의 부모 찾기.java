import java.io.*;
import java.util.*;

class Main{
    ArrayList<Integer>[] list;
    int[] answer;
    boolean[] visited;
    public void solution()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        answer = new int[N+1];
        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=0;i<=N;i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
            list[B].add(A);
        }

        dfs(1, 0);

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=N;i++){
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    public void dfs(int current, int previous){
        visited[current] = true;
        answer[current] = previous;
        for(int temp:list[current]){
            if(temp!=previous && !visited[temp]){
                dfs(temp, current);
            }
        }
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}