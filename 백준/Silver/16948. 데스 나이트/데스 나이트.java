import java.io.*;
import java.util.*;

class Main{
    private int N;
    private Pos start;
    private Pos end;
    private int[] dirX = {-2, -2, 0, 0, 2, 2};
    private int[] dirY = {-1, 1, -2, 2, -1, 1};
    private boolean[][] visited;
    private int result;

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        start = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), 0);
        end = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), 0);

        visited = new boolean[N][N];

        bfs();
        System.out.println(result==0?-1:result);
    }

    public void bfs(){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while(!queue.isEmpty()){
            Pos cur = queue.poll();

            for(int i=0;i<6;i++){
                int tempX = cur.x + dirX[i];
                int tempY = cur.y + dirY[i];
                int tempCount = cur.count+1;

                if(tempX < 0 || tempY < 0 || tempX >= N || tempY >= N){continue;}
                if(tempX == end.x && tempY == end.y){
                    result = tempCount;
                    return;
                }
                if(visited[tempX][tempY]){continue;}

                visited[tempX][tempY] = true;
                queue.add(new Pos(tempX, tempY, tempCount));
            }
        }
    }


    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

class Pos{
    public Pos(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }

    public int x, y, count;
}
