import java.io.*;
import java.util.*;

class Main{
    private int N;
    private int count;
    private ArrayList<Integer>[] list;
    private boolean[] visited;
    private boolean[] visited2;
    private int[] distance;
    private boolean check;
    private boolean check2;

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];

        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<Integer>();
        }
        visited = new boolean[N+1];

        for(int i=1;i<N+1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }


        for(int i=1;i<N+1;i++){
            if(!check){
                visited[i] = true;
                Dfs(i, i, i);
                if(!check){
                    visited[i] = false;
                }
            }
        }

        distance = new int[N];

        for(int i=1;i<N+1;i++){
            if(visited[i]){
                distance[i-1] = 0;
            }else{
                check2 = false;
                visited2 = new boolean[N+1];
                DfsCount(i, i);
                count = 0;
            }
        }

        for(int i=0;i<N;i++){
            bw.write(distance[i]+" ");
        }

        bw.close();
    }

    private void Dfs(int station, int start, int before){
        visited[station] = true;

        for(int temp:list[station]){
            if(temp != before && temp == start){
                check = true;
                return;
            }
            if(!visited[temp]){
                Dfs(temp, start, station);
                if(!check){
                    visited[temp] = false;
                }
            }
            if(check){
                return;
            }
        }
    }

    private void DfsCount(int station, int start){
        visited2[station] = true;
        if(check2){
            return;
        }
        if(visited[station]){
            distance[start-1] = count;
            check2 = true;
            return;
        }

        for(int temp:list[station]){
            if(!visited2[temp] && !check2){
                count++;
                DfsCount(temp, start);
                count--;
                visited2[temp] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

