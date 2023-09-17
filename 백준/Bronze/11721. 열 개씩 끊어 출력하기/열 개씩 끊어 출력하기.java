import java.util.Scanner;

class Main{
    
    public void solution(){
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        sc.close();
        for(int i=0;i<line.length();i++){
            System.out.print(line.charAt(i));
            if(i%10==9){
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args){
        new Main().solution();
    }
}