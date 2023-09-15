import java.io.*;
import java.util.*;

class Main {
    class Node{
        public Node(int value, int L_child, int R_child){
            this.value = value;
            this.L_child = L_child;
            this.R_child = R_child;
        }
        public int parent;
        public int value;
        public int L_child;
        public int R_child;
    }

    int[] levelMin;
    int[] levelMax;
    int count = 1;
    int maxLevel = 0;
    ArrayList<Node> tree = new ArrayList<Node>();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        levelMin = new int[N+1];
        levelMax = new int[N+1];

        for(int i=0;i<=N;i++){
            levelMin[i] = N;
            levelMax[i] = 0;
            tree.add(new Node(i, -1, -1));
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int L_value = Integer.parseInt(st.nextToken());
            int R_value = Integer.parseInt(st.nextToken());
            tree.get(value).L_child = L_value;
            tree.get(value).R_child = R_value;
            if(L_value!=-1){
                tree.get(L_value).parent = value;
            }
            if(R_value!=-1){
                tree.get(R_value).parent = value;
            }
        }
        int rootIdx = 0;
        for(int i=1;i<=N;i++){
            if(tree.get(i).parent == 0){
                rootIdx = i;
                break;
            }
        }

        inOrder(rootIdx, 1);

        int max = 0;
        int idx = 0;
        int length=0;
        for(int i=1;i<=maxLevel;i++){
            length = levelMax[i] - levelMin[i] + 1;
            if(max < length){
                max = length;
                idx = i;
            }
        }

        System.out.println(idx+" "+max);
    }

    public void inOrder(int currentIdx, int level){
        if(maxLevel < level){maxLevel = level;}
        if(tree.get(currentIdx).L_child != -1){
            inOrder(tree.get(currentIdx).L_child, level+1);
        }

        levelMax[level] = count;
        levelMin[level] = Math.min(levelMin[level], count);
        count++;

        if(tree.get(currentIdx).R_child != -1){
            inOrder(tree.get(currentIdx).R_child, level+1);
        }
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}