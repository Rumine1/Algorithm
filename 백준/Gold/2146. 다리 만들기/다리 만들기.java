import java.io.*;
import java.util.*;

class Main{
    private int N;
    private int[][] map;
    private boolean[][] visited;
    private int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private int minDistance=Integer.MAX_VALUE;

    class Position{
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][N];

        int group = 2;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1&&!visited[i][j]){
                    Dfs(i,j,group);
                    group++;
                }
            }
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]!=0){
                    visited = new boolean[N][N];
                    Bfs(i,j,map[i][j]);
                }
            }
        }
        System.out.println(minDistance-1);
    }

    private void Dfs(int x, int y, int group){
        visited[x][y]=true;
        map[x][y]=group;
        for(int i=0;i<4;i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx<0||ny<0||nx>=N||ny>=N){continue;}
            if(map[nx][ny]==0){continue;}
            if(visited[nx][ny]){continue;}
            Dfs(nx,ny,group);
        }

    }

    private void Bfs(int x, int y, int start){
        Queue<Position> queue = new LinkedList<Position>();
        visited[x][y] = true;
        queue.add(new Position(x,y));
        int distance = 0;
        while(!queue.isEmpty()){
            int length = queue.size();
            distance++;
            if(minDistance<distance){
                return;
            }
            while(length-->0){
                Position cur = queue.poll();
                for(int i=0;i<4;i++){
                    int nx = cur.getX() + dir[i][0];
                    int ny = cur.getY() + dir[i][1];

                    if(nx<0||ny<0||nx>=N||ny>=N){continue;}
                    if(map[nx][ny]==start){continue;}
                    if(map[nx][ny]!=0){
                        if(minDistance>distance){
                            minDistance = distance;
                        }
                        return;
                    }
                    if(visited[nx][ny]){continue;}
                    visited[nx][ny] = true;
                    queue.add(new Position(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

