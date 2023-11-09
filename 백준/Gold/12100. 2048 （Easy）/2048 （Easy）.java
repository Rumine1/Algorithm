import java.io.*;
import java.util.*;

class Main{
    private int N;
    private int[][] board;
    private int maxValue = Integer.MIN_VALUE;
    private boolean[][] visited;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //board 크기 입력, board 초기화
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        //board 값 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxValue);
    }

    //보드를 5번 이동시켰을 때의 모든 경우의 최대값을 비교해서 maxValue에 저장하는 메서드
    public void dfs(int depth){
        //이동 5번 한 후에는 최대값 비교해서 저장
        if(depth >= 5){
            maxValue = Math.max(maxValue, findMax());
            return;
        }

        //원래 board를 복제해서 저장함
        int[][] duplication = new int[N][N];
        for(int i=0;i<N;i++){
            duplication[i] = board[i].clone();
        }

        //board의 값을 바꾸면서 상하좌우로 이동
        for(int i=0;i<4;i++){
            move(i);
            dfs(depth+1);

            //move로 이동시키고 난 다음에는 board를 원래 값으로 만들어줌
            for(int j=0;j<N;j++){
                board[j] = duplication[j].clone();
            }
        }
    }

    public void move(int dir){
        switch(dir){
            case 0: //위로 몰기
                for(int i=0;i<N;i++){
                    int index = 0;
                    int block = 0;
                    for(int j=0;j<N;j++){
                        //현재 위치가 0이 아니라면
                        if(board[j][i]!=0){
                            //block(현재 방향 기준 합쳐질 수 있는 블록) 과 값이 같다면
                            if(board[j][i]==block){
                                //block 값의 위치에 현재 값의 2배를 해서 넣어주고 block과 현재위치는 0으로 초기화
                                board[index-1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            }else{//block 과 값이 같지 않다면
                                block = board[j][i];

                                //블록이 현재 미는 방향 반대에 몰려있는 경우 바로 모는 방향으로 이동시켜야 하기에 현재 위치를 0으로 초기화
                                //그리고 block에 저장한 값을 모는 방향으로 이동
                                //index가 현재위치가 0이 아니고 이전에 탐색한 값과 다른 경우에만 증가하기에 가능하다
                                board[j][i] = 0;
                                board[index][i] = block;

                                index++;
                            }
                        }
                    }
                }
                break;
            case 1: //아래로 몰기
                for(int i=0;i<N;i++){
                    int index = N-1;
                    int block = 0;
                    for(int j=N-1;j>=0;j--){
                        //현재 위치가 0이 아니라면
                        if(board[j][i]!=0){
                            //block(현재 방향 기준 합쳐질 수 있는 블록) 과 값이 같다면
                            if(board[j][i]==block){
                                //block 값의 위치에 현재 값의 2배를 해서 넣어주고 block과 현재위치는 0으로 초기화
                                board[index+1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            }else{//block 과 값이 같지 않다면
                                block = board[j][i];

                                //블록이 현재 미는 방향 반대에 몰려있는 경우 바로 모는 방향으로 이동시켜야 하기에 현재 위치를 0으로 초기화
                                //그리고 block에 저장한 값을 모는 방향으로 이동
                                //index가 현재위치가 0이 아니고 이전에 탐색한 값과 다른 경우에만 증가하기에 가능하다
                                board[j][i] = 0;
                                board[index][i] = block;

                                index--;
                            }
                        }
                    }
                }
                break;
            case 2: //오른쪽으로 몰기
                for(int i=0;i<N;i++){
                    int index = N-1;
                    int block = 0;
                    for(int j=N-1;j>=0;j--){
                        //현재 위치가 0이 아니라면
                        if(board[i][j]!=0){
                            //block(현재 방향 기준 합쳐질 수 있는 블록) 과 값이 같다면
                            if(board[i][j]==block){
                                //block 값의 위치에 현재 값의 2배를 해서 넣어주고 block과 현재위치는 0으로 초기화
                                board[i][index+1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            }else{//block 과 값이 같지 않다면
                                block = board[i][j];

                                //블록이 현재 미는 방향 반대에 몰려있는 경우 바로 모는 방향으로 이동시켜야 하기에 현재 위치를 0으로 초기화
                                //그리고 block에 저장한 값을 모는 방향으로 이동
                                //index가 현재위치가 0이 아니고 이전에 탐색한 값과 다른 경우에만 증가하기에 가능하다
                                board[i][j] = 0;
                                board[i][index] = block;

                                index--;
                            }
                        }
                    }
                }
                break;
            case 3: //왼쪽으로 몰기
                for(int i=0;i<N;i++){
                    int index = 0;
                    int block = 0;
                    for(int j=0;j<N;j++){
                        //현재 위치가 0이 아니라면
                        if(board[i][j]!=0){
                            //block(현재 방향 기준 합쳐질 수 있는 블록) 과 값이 같다면
                            if(board[i][j]==block){
                                //block 값의 위치에 현재 값의 2배를 해서 넣어주고 block과 현재위치는 0으로 초기화
                                board[i][index-1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            }else{//block 과 값이 같지 않다면
                                block = board[i][j];

                                //블록이 현재 미는 방향 반대에 몰려있는 경우 바로 모는 방향으로 이동시켜야 하기에 현재 위치를 0으로 초기화
                                //그리고 block에 저장한 값을 모는 방향으로 이동
                                //index가 현재위치가 0이 아니고 이전에 탐색한 값과 다른 경우에만 증가하기에 가능하다
                                board[i][j] = 0;
                                board[i][index] = block;

                                index++;
                            }
                        }
                    }
                }
                break;
        }
    }

    //현재 보드에서 최대값을 구해서 반환하는 메서드
    public int findMax(){
        int maxTemp = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                maxTemp = Math.max(maxTemp, board[i][j]);
            }
        }

        return maxTemp;
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}



