import java.io.*;
import java.util.*;

class Main{
    private int N,M;
    int[] parent = new int[100001];

    private void solution()  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(Bfs());

        int idx = M;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        stack.push(M);
        while(idx!=N){
            stack.push(parent[idx]);
            idx = parent[idx];
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString());
    }

    private int Bfs(){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(N);
        int[] time = new int[100001];
        time[N] = 1;
        while(!queue.isEmpty()){
            int x = queue.poll();
            if(x==M){
                return time[x]-1;
            }
            for(int i=0;i<3;i++){
                int nx = 0;
                if(i==0){
                    nx = x-1;
                } else if (i == 1) {
                    nx = x+1;
                }else{
                    nx = x*2;
                }

                if(nx>=0 && nx<100001 && time[nx]==0){
                    time[nx] = time[x] + 1;
                    parent[nx] = x;
                    queue.add(nx);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}


