import java.util.Scanner;

class Main{

    public void solution(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println((N-1)+N*(M-1));
    }

    public static void main(String[] args){
        new Main().solution();
    }
}