    import java.io.*;
    import java.util.*;

    class Main{
        public static class Position {
            int rx;
            int ry;
            int bx;
            int by;
            int count;
            public Position(int rx, int ry, int bx, int by, int count) {
                this.rx = rx;
                this.ry = ry;
                this.bx = bx;
                this.by = by;
                this.count = count;
            }
        }

        private int N, M;
        private char[][] map;
        private Position red, blue;
        private int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        private boolean[][][][] visited;
        public void solution() throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            visited = new boolean[N][M][N][M];

            for(int i=0;i<N;i++){
                String str = br.readLine();
                for(int j=0;j<M;j++){
                    map[i][j] = str.charAt(j);

                    if(map[i][j]=='R'){
                        red = new Position(i, j, 0, 0, 0);
                    }else if(map[i][j]=='B'){
                        blue = new Position(0, 0, i, j, 0);
                    }
                }
            }

            System.out.println(bfs(new Position(red.rx, red.ry, blue.bx, blue.by, 1)));
        }

        public int bfs(Position start){
            Queue<Position> queue = new LinkedList<>();
            queue.add(start);
            visited[start.rx][start.ry][start.bx][start.by] = true;

            while(!queue.isEmpty()){
                Position cur = queue.poll();

                int curRx = cur.rx;
                int curRy = cur.ry;
                int curBx = cur.bx;
                int curBy = cur.by;
                int curCount = cur.count;

                if(curCount > 10){
                    return -1;
                }

                for(int i=0;i<4;i++){
                    int newRx = curRx;
                    int newRy = curRy;
                    int newBx = curBx;
                    int newBy = curBy;

                    boolean isRedGoal = false;
                    boolean isBlueGoal = false;

                    //벽 만나면 멈춤
                    while(map[newRx+dir[i][0]][newRy+dir[i][1]]!='#'){
                        newRx += dir[i][0];
                        newRy += dir[i][1];

                        //움직이는 도중에 구멍에 들어감
                        if(map[newRx][newRy]=='O'){
                            isRedGoal = true;
                            break;
                        }
                    }

                    //벽 만나면 멈춤
                    while(map[newBx+dir[i][0]][newBy+dir[i][1]]!='#'){
                        newBx += dir[i][0];
                        newBy += dir[i][1];

                        //움직이는 도중에 구멍에 들어감
                        if(map[newBx][newBy]=='O'){
                            isBlueGoal = true;
                            break;
                        }
                    }

                    if(isBlueGoal){
                        continue;
                    }

                    if(isRedGoal){
                        return curCount;
                    }

                    //겹칠때
                    if(newRx==newBx && newRy==newBy){
                        if(i==0){ //오른쪽 기울이기 아래
                            if(cur.rx > cur.bx)newBx -= dir[i][0];
                            else newRx -= dir[i][0];
                        }else if(i==1){ //아래쪽 기울이기 오른
                            if(cur.ry > cur.by)newBy -= dir[i][1];
                            else newRy -= dir[i][1];
                        }else if(i==2){ //왼쪽 기울이기 위
                            if(cur.rx > cur.bx)newRx -= dir[i][0];
                            else newBx -= dir[i][0];
                        }else { //위쪽 기울이기 왼
                            if(cur.ry > cur.by)newRy -= dir[i][1];
                            else newBy -= dir[i][1];
                        }
                    }

                    if(!visited[newRx][newRy][newBx][newBy]){
                        visited[newRx][newRy][newBx][newBy] = true;
                        queue.add(new Position(newRx, newRy, newBx, newBy, curCount + 1));
                    }
                }
            }
            return -1;
        }

        public static void main(String[] args) throws IOException{
            new Main().solution();
        }
    }