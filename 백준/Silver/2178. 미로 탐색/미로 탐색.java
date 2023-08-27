import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    class Position{
        private int x;
        private int y;
        public Position(int x, int y){
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
    private int N;
    private int M;
    private String[] maze;
    private boolean[][] visited;
    private Queue<Position> queue = new LinkedList<Position>();
    private int[][] dir = {{0,1},{0, -1},{1,0},{-1,0}};
    private int[][] distance;

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new String[N];
        for(int i=0;i<N;i++){
            maze[i] = br.readLine();
        }

        visited = new boolean[N][M];
        distance = new int[N][M];

        Bfs(0, 0);
        System.out.println(distance[N-1][M-1]);
    }

    private void Bfs(int x, int y){
        boolean check = false;
        visited[x][y] = true;
        queue.add(new Position(x, y));
        distance[x][y] = 1;

        while(!check){
            Position temp = queue.poll();

            for(int i=0;i<4;i++){
                int nx = temp.getX() + dir[i][0];
                int ny = temp.getY() + dir[i][1];

                if(nx<0 || ny<0 || nx>=N || ny>=M){continue;}
                if(maze[nx].charAt(ny) != '1'){continue;}
                if(visited[nx][ny]){continue;}
                if(nx == N-1 && ny == M-1){
                    check = true;
                    distance[nx][ny] = distance[temp.getX()][temp.getY()]+1;
                    break;
                }

                visited[nx][ny] = true;
                queue.add(new Position(nx, ny));
                distance[nx][ny] = distance[temp.getX()][temp.getY()]+1;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}