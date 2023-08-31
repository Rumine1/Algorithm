import java.io.*;
import java.util.*;

class Main{
    class Position{
        private int x;
        private int y;
        private Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY(){
            return y;
        }
    }
    private int testCase;
    private int I;
    private Position startPoint;
    private Position targetPoint;
    private int[][] dir = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
    private Queue<Position> queue = new LinkedList<Position>();
    private boolean[][] visited;

    private int distance = 0;


    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        testCase = Integer.parseInt(br.readLine());

        for(int i =0;i<testCase;i++){
            I = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            startPoint = new Position(x1, y1);

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            targetPoint = new Position(x2, y2);

            if(x1 == x2 && y1 == y2){
                System.out.println(0);
                continue;
            }

            visited = new boolean[I][I];

            queue.add(startPoint);
            distance =0;
            Bfs();

            System.out.println(distance);
            queue.clear();
        }
    }

    private void Bfs(){
        while(!queue.isEmpty()){
            int tempSize = queue.size();
            distance++;
            while(tempSize-->0){
                Position temp = queue.poll();
                for(int i=0;i<8;i++){
                    int x = temp.getX() + dir[i][0];
                    int y = temp.getY() + dir[i][1];

                    if(x < 0 || y < 0 || x >= I || y >= I){continue;}
                    if(visited[x][y]){continue;}
                    if(x == targetPoint.getX() && y == targetPoint.getY()){return;}
                    visited[x][y] = true;
                    queue.add(new Position(x,y));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}