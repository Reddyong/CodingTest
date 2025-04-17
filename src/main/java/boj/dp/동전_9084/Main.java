package boj.dp.동전_9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int T, N, M;
    private static int[] coins, dp;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            // 변수 및 배열들 초기화
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            coins = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            dp = new int[M + 1];
            // 0원은 아무 동전도 사용하지 않은 경우 만들수 있다.
            dp[0] = 1;

            // 동전 순서 중복을 막기위해 단위가 작은 동전부터 더해나감
            for (int coin : coins) {
                for (int c = coin; c <= M; c++) {
                    dp[c] += dp[c - coin];
                }
            }

            System.out.println(dp[M]);
        }
    }
}
