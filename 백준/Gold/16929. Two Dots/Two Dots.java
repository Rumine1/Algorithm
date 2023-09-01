import java.io.*;
import java.util.*;

class Main{
    private int N;
    private int M;
    private StringBuilder[] board;
    private boolean[][] visited;
    private int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private boolean check;

    class Position{
        private int x;
        private int y;
        private Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        private int getX(){return x;}
        private int getY(){return y;}
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new StringBuilder[N];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            board[i] = new StringBuilder(br.readLine());
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    Position start = new Position(i,j);
                    Dfs(start, start,1);
                    if(check){
                        System.out.println("Yes");
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("No");
    }

    private void Dfs(Position present, Position start, int depth){
        depth++;
        for(int i=0;i<4;i++){
            if(check){
                return;
            }
            int nx = present.getX() + dir[i][0];
            int ny = present.getY() + dir[i][1];

            if(nx<0|| ny<0|| nx>=N || ny>=M){continue;}
            if(board[nx].charAt(ny)!=board[start.getX()].charAt(start.getY())){continue;}
            if(depth>=4 && nx == start.getX() && ny == start.getY()){
                check = true;
                return;
            }
            if(visited[nx][ny]){continue;}
            visited[nx][ny] = true;
            Dfs(new Position(nx,ny), start, depth);
            visited[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}