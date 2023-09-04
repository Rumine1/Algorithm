import java.io.*;
import java.util.*;

class Main{
    private int N;
    private ArrayList<Integer>[] list;
    private int[] example;
    private boolean check;
    private boolean[] visited;
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            list[a].add(b);
            list[b].add(a);
        }

        //문제로 주어진 탐색 순서
        example = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            example[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        visited = new boolean[N];

        if(example[0]!= 0){
            System.out.println(0);
            System.exit(0);
        }

        Bfs();
    }

    private void Bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[0] = true;
        queue.add(0);
        int index = 1;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            int count = 0;
            for(int temp:list[current]){
                if(!visited[temp]){
                    visited[temp] = true;
                    count++;
                }
            }

            for(int i = index;i<index+count;i++){
                if(!visited[example[i]]){
                    System.out.println(0);
                    System.exit(0);
                }else{
                    queue.add(example[i]);
                }
            }

            index += count;
        }
        System.out.println(1);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}