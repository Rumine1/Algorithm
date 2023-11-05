import java.io.*;
import java.util.*;

class Main {

    private int N;
    private int K;
    private boolean[] visited = new boolean[26];
    private int maxWord;
    private String[] word;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K<5){
            System.out.println(0);
            return;
        }else if(K==26){
            System.out.println(N);
            return;
        }

        word = new String[N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            str.replace("anta", "");
            str.replace("tica", "");
            word[i] = str;
        }

        visited['a'-'a'] = true;
        visited['n'-'a'] = true;
        visited['t'-'a'] = true;
        visited['i'-'a'] = true;
        visited['c'-'a'] = true;

        dfs(0, 5);

        System.out.println(maxWord);
    }

    public void dfs(int start, int depth){
        if(depth>=K){
            int count = 0;
            for(int i=0;i<word.length;i++){
                boolean check = false;
                for(int j=0;j<word[i].length();j++){
                    if(!visited[word[i].charAt(j)-'a']){
                        check = true;
                    }
                }

                if(!check){
                    count++;
                }
            }

            maxWord = Math.max(maxWord, count);
            
            if(maxWord==N){
                System.out.println(N);
                System.exit(0);
            }
            return;
        }

        for(int i=start;i<26;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}