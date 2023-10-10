import java.io.*;

class Main{
    private int N;
    private int count;
    private boolean[] checkX;
    private boolean[] crossUp;
    private boolean[] crossDown;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        checkX = new boolean[N];
        crossUp = new boolean[N*2];
        crossDown =new boolean[N*2];

        dfs(0);
        System.out.println(count);
    }

    public void dfs(int y){
        if(y >= N){
            count++;
            return;
        }

        for(int x=0;x<N;x++){
            if(checkX[x]||crossUp[x+y]||crossDown[x-y+N]){continue;}

            checkX[x] = true;
            crossUp[x+y] = true;
            crossDown[x-y+N] = true;

            dfs(y+1);

            checkX[x] = false;
            crossUp[x+y] = false;
            crossDown[x-y+N] = false;
        }
    }


    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}