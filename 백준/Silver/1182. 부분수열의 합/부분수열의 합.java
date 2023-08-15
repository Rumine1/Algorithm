import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main{

    private int N;
    private int S;
    private int[] seq;
    private int count;

    private void dfs(int idx, int start, int temp){

        if(idx == N){
            return;
        }

        for(int i = start; i < N ; i++){
            if(temp+seq[i]==S){
                count++;
            }
            dfs(idx+1, i+1, temp+seq[i]);
        }
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0, 0);
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}