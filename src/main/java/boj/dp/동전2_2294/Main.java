package boj.dp.동전2_2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static int[] dp, coins;
    private static final int MAX = 10000000;
    public static void main(String[] args) throws IOException {
        // dp 배열, 변수 초기화
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                if (i < coins[j]) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }

        if (dp[K] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K + 1];
        coins = new int[N];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }
    }
}
