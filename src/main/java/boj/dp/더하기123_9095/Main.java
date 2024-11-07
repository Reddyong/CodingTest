package boj.dp.더하기123_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int ans;
    static int[] numbers;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (int number : numbers) {
            ans = getResult(number);
            System.out.println(ans);
        }
    }

    private static int getResult(int number) {
        if (number == 1) {
            return 1;
        }

        if (number == 2) {
            return 2;
        }

        if (number == 3) {
            return 4;
        }

        dp = new int[number + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;


        for (int i = 4; i < number + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[number];
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        numbers = new int[T];
        ans = 0;

        for (int i = 0; i < T; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
    }
}
