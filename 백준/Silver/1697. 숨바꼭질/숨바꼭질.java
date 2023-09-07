import java.io.*;
import java.util.*;

class Main{
    private int N,M;
    private void solution()  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N>=M){
            System.out.println(N-M);
        }else{
            System.out.println(Bfs());
        }
    }

    private int Bfs(){
        int[] distance = new int[100001];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(N);
        distance[N] = 1;
        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int i=0;i<3;i++){
                int nx;
                if(i==0){
                    nx = x-1;
                } else if (i == 1) {
                    nx = x+1;
                }else{
                    nx = x*2;
                }

                if(nx==M){
                    return distance[x];
                }

                if(nx>=0 && nx<100001 && distance[nx]==0){
                    distance[nx] = distance[x] + 1;
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

