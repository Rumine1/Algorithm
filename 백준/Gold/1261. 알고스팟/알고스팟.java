import java.io.*;
import java.util.*;

class Main{
    private int M,N;
    class Position implements Comparable<Position>{
        private int x,y;
        private int count;
        private Position(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }


        @Override
        public int compareTo(Position o) {
            return this.count - o.count;
        }
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        StringBuilder[] sb = new StringBuilder[N];

        for(int i=0;i<N;i++){
            sb[i] = new StringBuilder(br.readLine());
        }
    
        bfs(N,M,sb);
    }

    private void bfs(int N, int M, StringBuilder[] sb){
        boolean[][] visited = new boolean[N][M]; //바로 이전 값을 탐색하는 걸 막는 용도
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

        Queue<Position> queue = new PriorityQueue<>();
        queue.add(new Position(0,0, 0));
        while(!queue.isEmpty()){
            Position current = queue.poll();
            if(current.x == N-1 && current.y == M-1){
                System.out.println(current.count);
            }
            for(int i=0;i<4;i++) {
                int nx = current.x + dir[i][0];
                int ny = current.y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {continue;}
                if(visited[nx][ny]){continue;}
                visited[nx][ny] = true;

                if(sb[nx].charAt(ny)=='0'){
                    queue.add(new Position(nx, ny, current.count));
                }else{
                    queue.add(new Position(nx,ny,current.count + 1));
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}
