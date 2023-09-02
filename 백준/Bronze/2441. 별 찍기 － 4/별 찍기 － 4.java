import java.util.Scanner;
class Main{
    private void solution(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=N;i>0;i--){
            for(int j=0;j<N-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        new Main().solution();
    }
}