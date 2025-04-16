package boj.dp.LCS_9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N, M;
    private static String str1, str2;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        // dp[i][j] : str1, str2 문자열의 각각 1 ~ i 부분, 1 ~ j 부분까지의 구간을 비교했을 때 LCS 의 값을 의미
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // 현재 문자가 같을 경우, 이전 LCS 에서 현재 문자 추가
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 현재 문자가 다른 경우, 현재 문자를 제외한 각각의 str1, str2 의 LCS 의 길이 중 최댓값 유지
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[N][M]);
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
