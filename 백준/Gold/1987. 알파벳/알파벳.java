import javax.swing.text.Position;
import java.io.*;
import java.util.*;

class Main {
    private int R;
    private int C;
    private StringBuilder[] board;
    private boolean[] alphabet = new boolean[26];
    private int maxValue;
    private class Position{
        private Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        private int x;
        private int y;

    }
    private int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new StringBuilder[R];

        for(int i=0;i<R;i++) {
            board[i] = new StringBuilder();
            board[i].append(br.readLine());
        }

        dfs(new Position(0, 0), 1,3);
        System.out.println(maxValue);
    }

    public void dfs(Position current, int depth, int prior){
        alphabet[board[current.y].charAt(current.x)-'A'] = true;

        if(maxValue<depth){
            maxValue = depth;
        }

        for(int i=0;i<4;i++){
            if(i==prior){continue;}

            int nx = current.x + dir[i][0];
            int ny = current.y + dir[i][1];

            if(nx<0||ny<0||nx>=C||ny>=R){continue;}
            if(alphabet[board[ny].charAt(nx)-'A']){continue;}

            dfs(new Position(nx,ny), depth+1, (i+2)%4);
            alphabet[board[ny].charAt(nx)-'A'] = false;
        }
    }


    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}