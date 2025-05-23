package boj.dp.동전1_2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (int coin : arr) {
            for (int i = coin; i <= K; i++) {
                dp[i] += dp[i - coin];
            }
        }

        System.out.println(dp[K]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[K + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
