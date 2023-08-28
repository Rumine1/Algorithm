import java.util.Scanner;

class Main{

    private void solution(){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(A+B);

        sc.close();
    }

    public static void main(String[] args){
        new Main().solution();
    }
}