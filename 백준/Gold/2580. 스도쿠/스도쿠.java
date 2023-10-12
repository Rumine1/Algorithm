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

    public void search(int y, int x){
        if(x==9){
            search(y+1,0);
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

        if(map[y][x]==0){
            for(int i=1;i<=9;i++){
                if(check(y,x,i)){
                    map[y][x] = i;
                    search(y,x+1);
                }
            }
            map[y][x] = 0;
            return;
        }

        search(y,x+1);
    }

    public boolean check(int y, int x, int value){
        for(int i=0;i<9;i++){
            if(map[i][x]==value){
                return false;
            }

            if(map[y][i]==value){
                return false;
            }
        }

        int startY = y/3 *3;
        int startX = x/3 *3;

        for(int i=startY;i<startY+3;i++){
            for(int j=startX;j<startX+3;j++){
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