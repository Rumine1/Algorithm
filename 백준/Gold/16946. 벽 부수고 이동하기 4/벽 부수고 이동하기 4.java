import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private int N, M;
    private char[][] map;
    private int[][] group;
    private HashMap<Integer, Integer> table = new HashMap<>();
    private int[] dirX = {1,-1, 0, 0};
    private int[] dirY = {0, 0, 1, -1};

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        group = new int[N][M];

        for(int i=0;i<N;i++){
            String column = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = column.charAt(j);
            }
        }

        int count = 1;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='0' && group[i][j]==0){
                    table.put(count, bfs(i, j, count));
                    count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='1'){
                    sb.append(pathCount(i, j));
                }else{
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public int bfs(int x, int y, int groupNum){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));
        int grpCnt = 1;
        group[x][y] = groupNum;

        while(!queue.isEmpty()){
            Pos current = queue.poll();

            for(int i=0;i<4;i++){
                int nx = current.x + dirX[i];
                int ny = current.y + dirY[i];

                if(nx<0||ny<0||nx>=N||ny>=M){continue;}
                if(group[nx][ny]!=0){continue;}
                if(map[nx][ny]!='0'){continue;}

                queue.add(new Pos(nx, ny));
                group[nx][ny] = groupNum;
                grpCnt++;
            }
        }

        return grpCnt;
    }

    public int pathCount(int x, int y){
        int count = 1;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<4;i++){
            int nx = x + dirX[i];
            int ny = y + dirY[i];

            if(nx<0||ny<0||nx>=N||ny>=M){continue;}
            if(group[nx][ny]==0){continue;}
            if(map[nx][ny]!='0'){continue;}

            set.add(group[nx][ny]);
        }

        for(int gNum:set){
            count += table.get(gNum);
        }

        return count%10;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

class Pos{
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }

    protected int x, y;
}
