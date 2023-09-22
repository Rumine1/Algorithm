import java.util.Scanner;

class Main{

    public void solution(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int second = 0;
        int count = 1;
        while(N>0){
            if(N<count)
                count = 1;
            N -= count;
            count++;
            second++;
        }
        System.out.println(second);
    }

    public static void main(String[] args){
        new Main().solution();
    }
}