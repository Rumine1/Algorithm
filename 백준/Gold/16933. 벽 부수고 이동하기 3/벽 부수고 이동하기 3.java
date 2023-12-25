import java.io.*;
import java.util.*;

public class Main {

    private int N, M, K;
    private int[] dirX = {1, 0, -1, 0};
    private int[] dirY = {0, 1, 0, -1};

    private int[][] map;
    private boolean[][][] visited;


    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[K+1][N][M];

        if(N==1&M==1){
            System.out.println(1);
            return;
        }

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j)-'0';

            }
        }

        System.out.println(bfs());
    }

    public int bfs(){
        Queue<Route> queue = new LinkedList<>();
        queue.add(new Route(0,0,0, true));
        visited[0][0][0] = true;

        int count = 0;
        while(!queue.isEmpty()){

            int length = queue.size();

            for(int s = 0;s<length;s++){
                Route current = queue.poll();

                if(current.x == N-1&&current.y == M-1){
                    return count+1;
                }

                for(int i=0;i<4;i++){
                    int nx = current.x + dirX[i];
                    int ny = current.y + dirY[i];
                    int brokenWall = current.brokenWall;
                    boolean day = current.day;

                    if(nx<0||ny<0||nx>=N||ny>=M){continue;}

                    if(map[nx][ny] == 1 && brokenWall < K){
                        if(day && !visited[brokenWall+1][nx][ny]){
                            visited[brokenWall+1][nx][ny] = true;
                            queue.add(new Route(nx, ny, brokenWall+1, false));
                        }else if(!day && !visited[brokenWall+1][nx][ny]){
                            queue.add(new Route(current.x, current.y, brokenWall, true));
                        }
                    }else if(map[nx][ny] == 0 && !visited[brokenWall][nx][ny]){
                        visited[brokenWall][nx][ny] = true;
                        queue.add(new Route(nx, ny, brokenWall, day?false:true));
                    }
                }
            }

            count++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}


class Route{
    public Route(int x, int y, int brokenWall, boolean day){
        this.x = x;
        this.y = y;
        this.brokenWall = brokenWall;
        this.day = day;
    }

    protected int x, y, brokenWall;
    protected boolean day;
}