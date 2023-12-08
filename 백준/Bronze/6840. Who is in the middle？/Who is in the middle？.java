import java.io.*;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if(a>=b){
            if(b>=c){
                System.out.println(b);
            }else{
                System.out.println(a>c?c:a);
            }
        }else{
            if(a>=c){
                System.out.println(a);
            }else{
                System.out.println(b>c?c:b);
            }
        }


    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
