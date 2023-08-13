import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private int N;
	private int[] result;
	private char[][] sign;

	private boolean isValid(int length) {
		for (int i = 0; i < length; i++) {
			int sum = 0;
			for (int j = i; j < length; j++) {
				sum += result[j];
				if (sign[i][j] != (sum == 0 ? '0' : sum > 0 ? '+' : '-')) {
					return false;
				}
			}
		}
		return true;
	}

	private void dfs(int idx) {
		if (idx == N) {
			String answer = "";
			for (int i = 0; i < N; i++) {
				answer += result[i] + " ";
			}
			System.out.println(answer);
			System.exit(0);
		}

		for (int i = -10; i <= 10; i++) {
			result[idx] = i;
			if (isValid(idx + 1)) {
				dfs(idx + 1);
			}
		}

	}
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String exam = br.readLine();
		int idx = 0;
		sign = new char[N][N];
		result = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				sign[i][j] = exam.charAt(idx++);
			}
		}

		dfs(0);

	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
