import java.io.*;
import java.util.*;

class Main{
    class Node{
        private int clipboard;
        private int total;
        private int time;
        private Node(int clipboard, int total, int time){
            this.clipboard = clipboard;
            this.total = total;
            this.time = time;
        }
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());

        System.out.println(bfs(S));
    }

    private int bfs(int target){
        boolean[][] visited = new boolean[1001][1001];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 1,0));
        visited[0][1] = true;
        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.total == target) {
                return current.time;
            }

            //클립보드 저장
            queue.add(new Node(current.total, current.total, current.time + 1));

            //붙여넣기
            if (current.clipboard != 0 && current.clipboard + current.total <= target && !visited[current.clipboard][current.clipboard+current.total]) {
                queue.add(new Node(current.clipboard, current.clipboard + current.total, current.time + 1));
                visited[current.clipboard][current.clipboard + current.total] = true;
            }

            //하나 삭제
            if (current.total > 1 && !visited[current.clipboard][current.total - 1]) {
                queue.add(new Node(current.clipboard, current.total - 1, current.time + 1));
                visited[current.clipboard][current.total - 1] = true;
            }
        }
        return 0;
    }


    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}

