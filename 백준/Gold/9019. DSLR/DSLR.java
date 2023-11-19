import java.io.*;
import java.util.*;

class Main{

    private boolean[] visited;

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<T;i++){
            visited = new boolean[10001];
            st = new StringTokenizer(br.readLine());
            sb.append(bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public String bfs(int A, int B){
        Queue<Pos> queue = new LinkedList<>();

        visited[A] = true;
        queue.add(new Pos(A, ""));

        while(!queue.isEmpty()){
            Pos cur = queue.poll();

            for(int i=0;i<4;i++){
                Pos temp;
                switch(i){
                    case 0: //명령어 D
                        temp = new Pos((cur.value*2)%10000, cur.command+"D");
                        break;
                    case 1: //명령어 S
                        if(cur.value > 0){
                            temp = new Pos(cur.value-1, cur.command+"S");
                        }else{
                            temp = new Pos(9999, cur.command+"S");
                        }
                        break;
                    case 2: //명령어 L
                        String str1 = Integer.toString(cur.value);
                        int length1 = str1.length();
                        for(int j=0;j<4-length1;j++){
                            str1 = "0"+str1;
                        }

                        String frontWord = str1.substring(0, 1);
                        str1 = str1.substring(1) + frontWord;
                        temp = new Pos(Integer.parseInt(str1), cur.command+"L");
                        break;
                    default: //명령어 R
                        String str2 = Integer.toString(cur.value);
                        int length2 = str2.length();
                        for(int j=0;j<4-length2;j++){
                            str2 = "0"+str2;
                        }

                        String backWord = str2.substring(str2.length()-1);
                        str2 = backWord + str2.substring(0, str2.length()-1);
                        temp = new Pos(Integer.parseInt(str2), cur.command+"R");
                        break;
                }

                if(visited[temp.value]){continue;}
                if(temp.value == B){
                    return temp.command;
                }

                visited[temp.value] = true;
                queue.add(temp);
            }
        }

        return "";
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}

class Pos{
    public Pos(int value, String command){
        this.value = value;
        this.command = command;
    }

    protected int value;
    protected String command;
}

