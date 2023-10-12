import java.io.*;
import java.util.*;

class Main{
    private int[][] map;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[9][9];
        for(int i=0;i<9;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0,0);
    }

    public void search(int x, int y){
        if(x==9){
            search(0,y+1);
            return;
        }

        if(y==9){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(map[x][y]==0){
            for(int i=1;i<=9;i++){
                if(check(x,y,i)){
                    map[x][y] = i;
                    search(x+1,y);
                }
            }
            map[x][y] = 0;
            return;
        }

        search(x+1,y);
    }

    public boolean check(int x, int y, int value){
        for(int i=0;i<9;i++){
            if(map[i][y]==value){
                return false;
            }

            if(map[x][i]==value){
                return false;
            }
        }

        int startX = x/3 *3;
        int startY = y/3 *3;

        for(int i=startX;i<startX+3;i++){
            for(int j=startY;j<startY+3;j++){
                if(map[i][j]==value){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}