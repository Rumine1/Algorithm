import java.io.*;
import java.util.*;

class Main {
    class queueNode {
        private int value;
        private queueNode nextNode;

        private queueNode(int value) {
            this.value = value;
            this.nextNode = null;
        }

        private int getValue() {
            return this.value;
        }

        private queueNode getNextNode() {
            return this.nextNode;
        }

        private void setNextNode(queueNode nextNode) {
            this.nextNode = nextNode;
        }
    }

    class queueManager {
        queueNode front, rear;

        private queueManager() {
            front = rear = null;
        }

        private boolean isEmpty() {
            return front == null;
        }

        private void push(int value) {
            queueNode node = new queueNode(value);
            if (isEmpty()) {
                front = rear = node;
            } else {
                rear.setNextNode(node);
                rear = node;
            }
        }

        private void pop() {
            if (isEmpty()) {
                System.out.println(-1);
            } else {
                queueNode popNode = front;
                front = front.getNextNode();
                System.out.println(popNode.getValue());
            }
        }

        private void size() {
            int count = 0;
            queueNode current = front;
            while (current != null) {
                count++;
                current = current.getNextNode();
            }
            System.out.println(count);
        }

        private void empty() {
            if (isEmpty()) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        private void front() {
            if (isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(front.getValue());
            }
        }

        private void back() {
            if (isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(rear.getValue());
            }
        }
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String command;
        int num;
        queueManager queue = new queueManager();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            if (command.equals("push")) {
                num = Integer.parseInt(st.nextToken());
                queue.push(num);
            } else if (command.equals("pop")) {
                queue.pop();
            } else if (command.equals("size")) {
                queue.size();
            } else if (command.equals("empty")) {
                queue.empty();
            } else if (command.equals("front")) {
                queue.front();
            } else if (command.equals("back")) {
                queue.back();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
