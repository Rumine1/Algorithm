import java.io.*;
import java.util.*;

class Main{
    private int N;
    private int M;
    private int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private int minValue = Integer.MAX_VALUE;
    private StringBuilder[] sb;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder[N];
        for(int i=0;i<N;i++){
            sb[i] = new StringBuilder();
            sb[i].append(br.readLine());
        }

        int[] coin = new int[4];
        int count = 0;
        //동전 좌표 찾기
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(sb[i].charAt(j)=='o'){
                   coin[count++] = i;
                   coin[count++] = j;
                }
            }
        }

        dfs(0, coin[0], coin[1], coin[2], coin[3]);

        if(minValue>10){
            System.out.println(-1);
        }else{
            System.out.println(minValue);
        }
    }

    public void dfs(int depth, int x1, int y1, int x2, int y2){
        if(depth>10){
            return;
        }

        for(int i=0;i<4;i++){
            int nx1 = x1 + dir[i][0];
            int ny1 = y1 + dir[i][1];
            int nx2 = x2 + dir[i][0];
            int ny2 = y2 + dir[i][1];

            if(inspect(nx1, ny1) && inspect(nx2, ny2)){
                continue;
            }else if(inspect(nx1, ny1) ^ inspect(nx2, ny2)){
                minValue = Math.min(minValue, depth+1);
                return;
            }

            if(sb[nx1].charAt(ny1)=='#'){
                nx1 = x1;
                ny1 = y1;
            }
            if(sb[nx2].charAt(ny2)=='#'){
                nx2 = x2;
                ny2 = y2;
            }

            dfs(depth+1, nx1, ny1, nx2, ny2);
        }
    }

    public boolean inspect(int x, int y){
        if(x<0||y<0||x>=N||y>=M){
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}