import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        sb.append("  ___  ___  ___").append("\n");
        sb.append("  | |__| |__| |").append("\n");
        sb.append("  |           |").append("\n");
        sb.append("   \\_________/").append("\n");
        sb.append("    \\_______/").append("\n");
        sb.append("     |     |").append("\n");
        sb.append("     |     |").append("\n");
        sb.append("     |     |").append("\n");
        sb.append("     |     |").append("\n");
        sb.append("     |_____|").append("\n");
        sb.append("  __/       \\__").append("\n");
        sb.append(" /             \\").append("\n");
        sb.append("/_______________\\").append("\n");

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}