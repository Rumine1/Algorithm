import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    private int N;
    private int[] map;
    private boolean[] visited;
    private int count;
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N*N];
        visited = new boolean[N*N];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                map[i*N+j] = s.charAt(j)-'0';
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i=0;i<N*N;i++){
            count = 0;
            if(map[i]==1 && !visited[i]){
                //System.out.println(i+"번째 탐색");
                Dfs(i);
            }
            if(count!=0){
                result.add(count);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

    private void Dfs(int idx){
        visited[idx] = true;
        count++;
        for(int i=idx;i<N*N;i++){
            if((idx)%N+1<N){
                if(map[idx+1]==1 && !visited[idx+1]){
                    //System.out.println("right");
                    Dfs(idx+1);
                }
            }
            if((idx)/N+1<N){
                if(map[idx+N]==1 && !visited[idx+N]){
                    //System.out.println("down");
                    Dfs(idx+N);
                }
            }
            if((idx)%N-1>=0){
                if(map[idx-1]==1 && !visited[idx-1]){
                    //System.out.println("left");
                    Dfs(idx-1);
                }
            }
            if((idx)/N-1>=0){
                if(map[idx-N]==1 && !visited[idx-N]){
                    //System.out.println("up");
                    Dfs(idx-N);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}