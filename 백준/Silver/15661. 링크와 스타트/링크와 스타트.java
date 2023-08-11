import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int N;
	private int[][] S;
	private int minValue;
	private boolean[] visited;

	public void sumStatus() {
		int startTeam = 0;
		int linkTeam = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[j] == true && visited[i] == true) {
					startTeam += S[i][j];
					startTeam += S[j][i];
				} else if (visited[j] == false && visited[i] == false) {
					linkTeam += S[i][j];
					linkTeam += S[j][i];
				}
			}
		}

		minValue = Math.min(minValue, Math.abs(startTeam - linkTeam));
		
		if (minValue == 0) {
			System.out.println(0);
			System.exit(0);
		}

	}

	public void divideTeam(int idx, int start) {

		if (idx == N - 1) {
			return;
		}

		if (idx >= 1 && idx < N - 1) {
			sumStatus();
		}

		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				divideTeam(idx + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		minValue = Integer.MAX_VALUE;
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divideTeam(0, 0);

		System.out.println(minValue);

	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
