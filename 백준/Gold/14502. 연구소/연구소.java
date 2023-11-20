import java.io.*;
import java.util.*;

class Main{
    private int N, M;
    private int[][] map;
    private int result = 0;
    private int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(result);
    }

    public void dfs(int depth){
        if(depth==3){
            int[][] tempMap = new int[N][M];
            for(int i=0;i<N;i++){
                tempMap[i] = map[i].clone();
            }

            bfs(tempMap);

            result = Math.max(result, count(tempMap));
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public void bfs(int[][] tempMap){
        Queue<VPos> queue = new LinkedList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==2){
                    queue.add(new VPos(i, j));
                }
            }
        }

        while(!queue.isEmpty()){
            VPos cur = queue.poll();

            for(int i=0;i<4;i++){
                int dx = cur.x + dir[i][0];
                int dy = cur.y + dir[i][1];

                if(dx<0 || dy<0 || dx >= N || dy >= M){continue;}
                if(tempMap[dx][dy]==1){continue;}
                if(tempMap[dx][dy]==2){continue;}

                tempMap[dx][dy] = 2;
                queue.add(new VPos(dx, dy));
            }
        }
    }

    public int count(int[][] tempMap){
        int countZero = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tempMap[i][j]==0){
                    countZero++;
                }
            }
        }

        return countZero;
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

class VPos{
    public VPos(int x, int y){
        this.x = x;
        this.y = y;
    }

    protected int x;
    protected int y;
}
