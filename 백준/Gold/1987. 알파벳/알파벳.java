import javax.swing.text.Position;
import java.io.*;
import java.util.*;

class Main {
    private int R;
    private int C;
    private int[][] board;
    private boolean[] alphabet = new boolean[26];
    private int maxValue;
    private int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0,3);
        System.out.println(maxValue);
    }

    public void dfs(int x, int y, int depth, int prior){
        if(depth==26){
            System.out.println(26);
            System.exit(0);
        }

        if(alphabet[board[x][y]]){
            maxValue = Math.max(maxValue,depth);
            return;
        }

        alphabet[board[x][y]] = true;

        for(int i=0;i<4;i++){
            if(i==prior){continue;}

            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx<0||ny<0||nx>=R||ny>=C){continue;}

            dfs(nx, ny, depth+1, (i+2)%4);
        }
        alphabet[board[x][y]] = false;

    }


    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}