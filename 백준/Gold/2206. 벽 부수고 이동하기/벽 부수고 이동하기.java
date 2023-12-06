import java.io.*;
import java.util.*;

class Main{
    private int N, M;
    private boolean[][] map;
    private boolean[][][] visited;
    private int[] dirX = {1, 0, -1, 0};
    private int[] dirY = {0, 1, 0, -1};
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visited = new boolean[N][M][2];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j)=='0'?true:false;
            }
        }

        if(N==1&&M==1){
            System.out.println(1);
            return;
        }
        System.out.println(bfs(new Pos(0,0, 1,false)));

    }

    public int bfs(Pos first){
        Queue<Pos> queue = new LinkedList<>();
        visited[first.x][first.y][0] = true;
        queue.add(first);

        while(!queue.isEmpty()){
            Pos cur = queue.poll();

            for(int i=0;i<4;i++){
                int nx = cur.x + dirX[i];
                int ny = cur.y + dirY[i];
                int count = cur.count;
                boolean check = cur.check;

                if(nx<0||ny<0||nx>=N||ny>=M){continue;}
                if(nx == N-1 && ny == M-1){
                    return count+1;
                }
                if(!map[nx][ny]){
                    if(check){continue;}
                    if(!check){
                        check = true;
                    }
                }
                if(visited[nx][ny][check? 1:0]){continue;}

                visited[nx][ny][check?1:0] = true;

                queue.add(new Pos(nx, ny, count+1, check));
            }

        }

        return -1;
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

class Pos{
    public Pos(int x, int y, int count, boolean check){
        this.x = x;
        this.y = y;
        this.count = count;
        this.check = check;
    }

    protected int x, y, count;
    protected boolean check;
}
