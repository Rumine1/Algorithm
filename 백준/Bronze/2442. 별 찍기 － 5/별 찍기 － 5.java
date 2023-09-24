import java.util.Scanner;

class Main{

    public void solution(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int count = 0;
        for(int i=N;i>0;i--){
            for(int j=0;j<i-1;j++){
                System.out.print(" ");
            }
            count++;
            for(int j=0;j<2*count-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        new Main().solution();
    }
}