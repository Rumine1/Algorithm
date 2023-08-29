import java.io.*;
import java.util.*;

class Main{
    private int N;
    private int M;
    private int[][] storage;
    private int[][] distance;
    private int finalDistance;
    private int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private Queue<Position> queue = new LinkedList<Position>();

    class Position{
        private int x;
        private int y;
        private Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        private int getX(){
            return this.x;
        }
        private int getY(){
            return this.y;
        }
    }

    private boolean check(){
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(storage[i][j]== 0){
                    return false;
                }
            }
        }
        return true;
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        storage = new int[M][N];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                storage[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        distance = new int[M][N];

        //다 익었는지 확인
        if(check()){
            System.out.println(0);
            System.exit(0);
        }

        //전체 토마토틀을 한번 순회
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(storage[i][j]== 1){
                    queue.add(new Position(i, j));
                }
            }
        }
        bfs();

        //안 익은게 있는지 확인
        if(check()){
            System.out.println(finalDistance);
        }else{
            System.out.println(-1);
        }
    }

    public void bfs(){
        while(!queue.isEmpty()){
            Position tomato = queue.poll();
            for(int i=0;i<4;i++){
                int nx = tomato.getX() + dir[i][0];
                int ny = tomato.getY() + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N){continue;}
                if(storage[nx][ny] != 0){continue;}
                queue.add(new Position(nx, ny));
                storage[nx][ny] = 1;
                distance[nx][ny] = distance[tomato.getX()][tomato.getY()]+1;
                if(finalDistance < distance[nx][ny]){
                    finalDistance = distance[nx][ny];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
