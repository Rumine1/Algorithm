import java.io.*;
import java.util.*;

class Main{
    private boolean[][] visited;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if((a+b+c)%3!=0){
            System.out.println(0);
            return;
        }

        System.out.println(bfs(new Rock(a,b,c)));
    }

    public int bfs(Rock first){
        Queue<Rock> queue = new LinkedList<>();
        visited = new boolean[1501][1501];

        visited[first.a][first.b] = true;
        queue.add(first);

        int a = 0;
        int b = 0;
        int c = 0;
        while(!queue.isEmpty()){
            Rock cur = queue.poll();

            a = cur.a;
            b = cur.b;
            c = cur.c;

            if(a==b && b==c){
                return 1;
            }

            if(a!=b){
                int na = a>b?a-b:a+a;
                int nb = a>b?b+b:b-a;

                if(!visited[na][nb]){
                    queue.add(new Rock(na, nb, c));
                    visited[na][nb] = true;
                }
            }

            if(a!=c){
                int na = a>c?a-c:a+a;
                int nc = a>c?c+c:c-a;

                if(!visited[na][nc]){
                    queue.add(new Rock(na, b, nc));
                    visited[na][nc] = true;
                }
            }

            if(b!=c){
                int nb = b>c?b-c:b+b;
                int nc = b>c?c+c:c-b;

                if(!visited[nb][nc]){
                    queue.add(new Rock(a, nb, nc));
                    visited[nb][nc] = true;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

class Rock{
    protected int a, b, c;

    public Rock(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

}