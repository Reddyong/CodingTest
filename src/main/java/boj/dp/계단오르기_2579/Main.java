package boj.dp.계단오르기_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int stairCount;
    static int[] stairs;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    private static void solve() {
        for (int i = 3; i < stairs.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(dp[stairCount]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stairCount = Integer.parseInt(br.readLine());
        stairs = new int[stairCount + 1];
        dp = new int[stairCount + 1];

        for (int i = 1; i <= stairCount; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];
        if (stairCount >= 2) {
            dp[2] = dp[1] + stairs[2];
        }
    }
}
