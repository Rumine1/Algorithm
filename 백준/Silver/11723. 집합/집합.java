import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int M = Integer.parseInt(br.readLine());
		int answer = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			switch (command) {
			case "all":
				answer = (1 << 21) - 1;
				break;
			case "empty":
				answer = 0;
				break;
			default:
				int num = Integer.parseInt(st.nextToken());
				switch (command) {
				case "add":
					answer |= 1 << num;
					break;
				case "remove":
					answer &= ~(1 << num);
					break;
				case "check":
					bw.write(String.valueOf((answer & (1 << num)) != 0 ? 1 : 0));
					bw.newLine();
					break;
				case "toggle":
					answer ^= 1 << num;
					break;
				}

			}

		}
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}