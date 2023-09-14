import java.io.*;
import java.nio.Buffer;
import java.util.*;

class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    class Node {
        private char current;
        private Node L_child;
        private Node R_child;

        public Node(char current, Node L_child, Node R_child) {
            this.current = current;
            this.L_child = L_child;
            this.R_child = R_child;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node root = new Node('A', null, null);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            insertNode(root, st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        preOrder(root);
        bw.newLine();
        inOrder(root);
        bw.newLine();
        postOrder(root);
        bw.close();
    }

    public void insertNode(Node temp, char current, char L_value, char R_value){
        if(temp.current == current){
            temp.L_child = L_value=='.'?null:new Node(L_value, null, null);
            temp.R_child = R_value=='.'?null:new Node(R_value, null, null);
        }else{
            if(temp.L_child!=null){insertNode(temp.L_child, current, L_value, R_value);}
            if(temp.R_child!=null){insertNode(temp.R_child, current, L_value, R_value); }
        }
    }


    public void preOrder(Node tree) throws IOException {
        if(tree == null){
            return;
        }
        bw.write(tree.current);
        preOrder(tree.L_child);
        preOrder(tree.R_child);
    }

    public void inOrder(Node tree) throws IOException {
        if(tree == null){
            return;
        }
        inOrder(tree.L_child);
        bw.write(tree.current);
        inOrder(tree.R_child);
    }

    public void postOrder(Node tree) throws IOException {
        if(tree == null){
            return;
        }
        postOrder(tree.L_child);
        postOrder(tree.R_child);
        bw.write(tree.current);
    }

    public static void main(String[] args)throws IOException{
        new Main().solution();
    }
}