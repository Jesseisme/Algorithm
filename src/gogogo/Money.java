package gogogo;

import java.util.Arrays;
import java.util.Scanner;

public class Money {
	public static long getNum(int n) {
		int coins[] = { 1, 5, 10, 20, 50, 100 };
		int l = coins.length;
		long dp[][] = new long[l][n + 1];
		Arrays.fill(dp[0], 1);
		for (int i = 1; i < l; i++) {
			for (int j = 1; j <= n; j++) {
				int m = j / coins[i];
				for (int k = 0; k <= m; k++) {
					dp[i][j] = dp[i][j] + dp[i - 1][j - k * coins[i]];
				}
			}
		}
		return dp[l - 1][n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int num = scanner.nextInt();
			System.out.println(getNum(num));
		}
	}

}
