package boj.dp.LCS2_9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String str1, str2;
    private static int N, M;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int r = N;
        int c = M;
        StringBuilder sb = new StringBuilder();

        while (r > 0 && c > 0) {
            if (str1.charAt(r - 1) == str2.charAt(c - 1)) {
                sb.insert(0, str1.charAt(r - 1));
                r--;
                c--;
            } else {
                if (dp[r - 1][c] > dp[r][c - 1]) {
                    r--;
                } else {
                    c--;
                }
            }
        }

        String answer = sb.toString();

        System.out.println(dp[N][M]);
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();

        N = str1.length();
        M = str2.length();

        dp = new int[N + 1][M + 1];
    }
}
