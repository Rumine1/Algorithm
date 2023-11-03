import java.io.*;

class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count1 = 0;
        int count2 = 0;

        for(int i=0;i<N;i++){
            char result = br.readLine().charAt(0);
            if(result == 'D'){
                count1++;
            }else{
                count2++;
            }
            if(Math.abs(count1-count2)>=2){
                break;
            }
        }
        System.out.println(count1+":"+count2);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}