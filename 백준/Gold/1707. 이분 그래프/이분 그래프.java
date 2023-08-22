import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main{
    private int K;
    private int V;
    private int E;
    private ArrayList<Integer>[] list;
    private int[] divide;
    private boolean check;

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            list = new ArrayList[V];
            divide = new int[V];
            for(int j=0;j<V;j++){
                list[j] = new ArrayList<>();
            }

            for(int j=0;j<E;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a-1].add(b-1);
                list[b-1].add(a-1);
            }
            check = false;
            for(int k=0;k<V;k++){
                Dfs(k, divide[k]);
                if(check){
                    bw.write("NO");
                    break;
                }
            }
            if(!check){
                bw.write("YES");
            }
            bw.newLine();
        }
        bw.close();
    }

    private void Dfs(int idx, int mark){
        if(mark==0){
            divide[idx] = 1;
        }else{
            divide[idx] = mark;
        }

        for(int temp:list[idx]){
            if(divide[idx]==divide[temp]){
                check=true;
                return;
            }
            if(divide[temp]==0){
                Dfs(temp,divide[idx]*(-1));
            }
        }

    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}