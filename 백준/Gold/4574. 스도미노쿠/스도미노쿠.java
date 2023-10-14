import java.io.*;
import java.util.*;

class Main {
    private int[][] map;
    int count = 0;

    class CustomException extends Exception {
    }

    private int[] dirRow = {0, 1};
    private int[] dirCol = {1, 0};
    private boolean[][] tail;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = 0;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            map = new int[9][9];
            tail = new boolean[10][10];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int num1 = Integer.parseInt(st.nextToken());
                String s = st.nextToken();
                int row = s.charAt(0) - 'A';
                int col = s.charAt(1) - '1';
                map[row][col] = num1;

                int num2 = Integer.parseInt(st.nextToken());
                s = st.nextToken();
                row = s.charAt(0) - 'A';
                col = s.charAt(1) - '1';
                map[row][col] = num2;

                tail[num1][num2] = true;
                tail[num2][num1] = true;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                String s = st.nextToken();
                int row = s.charAt(0) - 'A';
                int col = s.charAt(1) - '1';
                map[row][col] = i + 1;
            }

            try {
                search(0, 0);
            } catch (CustomException e) {

            }
        }
    }

    public void search(int y, int x) throws CustomException{
        if(x==9){
            search(y+1,0);
            return;
        }

        if(y==9){
            StringBuilder sb = new StringBuilder();
            sb.append("Puzzle ").append(++count).append("\n");
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);

            throw new CustomException();
        }

        if(map[y][x]!=0){
            search(y,x+1);
            return;
        }


        for(int i=1;i<=9;i++){
            if(!check(y,x,i)){
                continue;
            }
            for(int j=0;j<2;j++){
                int newY = y + dirRow[j];
                int newX = x + dirCol[j];
                try{
                    if(map[newY][newX]!=0){
                        continue;
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    continue;
                }
                for(int k=1;k<=9;k++){
                    if(tail[i][k]||!check(newY, newX, k)||k==i) continue;
                    map[y][x] = i;
                    map[newY][newX] = k;
                    tail[i][k] = true;
                    tail[k][i] = true;
                    search(y,x+1);
                    map[y][x] = 0;
                    map[newY][newX] = 0;
                    tail[i][k] = false;
                    tail[k][i] = false;
                }
            }
        }
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