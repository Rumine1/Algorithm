import java.util.Scanner;

class Main{
    private void solution(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i =N;i>0;i--){
            System.out.println(i);
        }
    }

    public static void main(String[] args){
        new Main().solution();
    }
}
