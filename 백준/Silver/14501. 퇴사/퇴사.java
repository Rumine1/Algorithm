import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int N;
	private int[] T;
	private int[] P;
	private int maxValue;

	private void dfs(int idx, int pay) {
		if (idx >= N) {
			maxValue = Math.max(maxValue, pay);
			return;
		}

		if (idx + T[idx] <= N) {
			dfs(idx + T[idx], pay + P[idx]);
		} else {
			dfs(idx + T[idx], pay);
		}

		dfs(idx + 1, pay);
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		maxValue = 0;
		dfs(0, 0);
		System.out.println(maxValue);
	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

}
