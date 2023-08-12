import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int k;
	private char[] sign;
	private String maxValue;
	private String minValue;
	private boolean[] visited;

	private boolean isValid(int index, int defined, int temp) {
		if (sign[index] == '>') {
			return defined > temp;
		} else {
			return defined < temp;
		}
	}

	private void compare(String num) {
		if (maxValue.compareTo(num) < 0) {
			maxValue = num;
		}
		if (minValue.compareTo(num) > 0) {
			minValue = num;
		}
	}

	private void dfs(int idx, String num) {
		if (idx == k + 1) {
			compare(num);
			return;
		}

		for (int j = 0; j < 10; j++) {
			if (idx == 0 || !visited[j] && isValid(idx - 1, num.charAt(idx - 1) - '0', j)) {
				visited[j] = true;
				dfs(idx + 1, num + j);
				visited[j] = false;
			}
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		sign = new char[k];
		for (int i = 0; i < k; i++) {
			sign[i] = st.nextToken().charAt(0);
		}

		visited = new boolean[10];

		maxValue = "0";
		minValue = "9999999999";

		dfs(0, "");

		System.out.println(maxValue);
		System.out.println(minValue);

	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
