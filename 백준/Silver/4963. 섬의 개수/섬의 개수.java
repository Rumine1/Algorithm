import java.io.*;
import java.util.*;

class Main{
    private int w;
    private int h;
    private String[] map;
    private boolean[][] visited;
    private int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    private int count;
    private ArrayList<Integer> result;

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        result = new ArrayList<Integer>();

        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 & h == 0){
                break;
            }

            map = new String[h];
            for(int i=0;i<h;i++){
                map[i] = br.readLine().replaceAll(" ", "");
            }
            visited = new boolean[h][w];

            count = 0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(map[i].charAt(j) == '1' && !visited[i][j]){
                        count++;
                        Dfs(i,j);
                    }
                }
            }
            result.add(count);
        }
        
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

    private void Dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0;i<8;i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx<0 || ny<0 || nx>=h || ny >= w){continue;}
            if(map[nx].charAt(ny) == '0'){continue;}
            if(visited[nx][ny]){continue;}
            Dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}