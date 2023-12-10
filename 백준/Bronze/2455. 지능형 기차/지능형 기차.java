import java.io.*;
import java.util.*;

class Main{

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int getOn = 0;
        int getOff = 0;
        int maxRider = 0;
        int current = 0;
        for(int i=0;i<4;i++){
            st = new StringTokenizer(br.readLine());
            getOff = Integer.parseInt(st.nextToken());
            getOn = Integer.parseInt(st.nextToken());

            current += getOn-getOff;
            maxRider = Math.max(maxRider, current);
        }

        System.out.println(maxRider);

    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
