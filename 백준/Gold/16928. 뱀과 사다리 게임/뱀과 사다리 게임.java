import java.io.*;
import java.util.*;

class Main{

    private int[] ladder;
    private int[] snake;
    private int result = 0;
    private boolean[] visited;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ladder = new int[101];
        snake = new int[101];
        visited = new boolean[101];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a] = b;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            snake[a] = b;
        }

        bfs();
        System.out.println(result);
    }

    public void bfs(){
        Queue<Integer> queue= new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int count = 0;
        while(!queue.isEmpty()){

            count++;
            int length = queue.size();
            while(length-->0) {
                int cur = queue.poll();

                for(int i=1;i<=6;i++){
                    int temp = cur + i;

                    if(temp > 100){
                        break;
                    }

                    if(temp == 100){
                        result = count;
                        return;
                    }

                    if(ladder[temp] != 0 && !visited[temp]){
                        visited[temp] = true;
                        queue.add(ladder[temp]);
                        continue;
                    }

                    if(snake[temp] != 0 && !visited[temp]){
                        visited[temp] = true;
                        queue.add(snake[temp]);
                        continue;
                    }

                    if(!visited[temp]){
                        visited[temp] = true;
                        queue.add(temp);
                    }

                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
