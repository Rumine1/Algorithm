import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	private int L, C;
	private char[] words;
	private char[] result;

	private boolean isValid() {
		int consonant = 0;
		int vowel = 0;

		for (char w : result) {
			if (w == 'a' || w == 'e' || w == 'i' || w == 'o' || w == 'u') {
				consonant++;
			} else {
				vowel++;
			}
		}
		if (consonant >= 1 && vowel >= 2) {
			return true;
		}
		return false;

	}

	private void dfs(int idx, int start) {
		if (idx == L) {
			if (isValid()) {
				System.out.println(result);
			}
			return;
		}

		for (int i = start; i < C; i++) {
			result[idx] = words[i];
			dfs(idx + 1, i + 1);
		}

	}


	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		words = new char[C];
		result = new char[L];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			words[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(words);

		dfs(0, 0);

	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

}
