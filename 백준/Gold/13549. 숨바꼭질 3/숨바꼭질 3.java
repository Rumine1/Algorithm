import java.io.*;
import java.util.*;

class Main{
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
    }

    private void bfs(int start, int target){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] time = new int[100001];
        time[start] = 1;
        int count = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == target){
                System.out.println(time[current]-1);
                return;
            }

            for(int i=0;i<3;i++){
                int nx = 0;
                if(i==0){
                    nx = current+1;
                }else if(i==1){
                    nx = current-1;
                }else{
                    nx = current*2;
                }

                if(nx<0 || nx >= 100001){continue;}

                if(i!=2 && (time[nx]==0 || time[nx] > time[current]+1)){
                    time[nx] = time[current] + 1;
                    queue.add(nx);
                }else if(i==2 && (time[nx]==0 || time[nx] > time[current])){
                    time[nx] = time[current];
                    queue.add(nx);
                }

            }
        }
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}
