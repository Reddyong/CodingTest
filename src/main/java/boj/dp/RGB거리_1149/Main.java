package boj.dp.RGB거리_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int ans;
    static int[][] RGB;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                int temp = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k == j) {
                        continue;
                    }

                    temp = Math.min(temp, dp[i - 1][k]);
                }
                dp[i][j] = temp + RGB[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, dp[N][i]);
        }

        System.out.println(ans);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        RGB = new int[N + 1][3];
        dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[1][i] = RGB[1][i];
        }
    }
}
