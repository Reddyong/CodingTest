package boj.수학.이항계수2_11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        makeArr();

        System.out.println(dp[N][K] % 10007);
    }

    private static void makeArr() {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] % 10007 + dp[i - 1][j] % 10007;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];
    }
}
