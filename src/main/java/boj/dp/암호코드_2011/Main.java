package boj.dp.암호코드_2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private static String N;
    private static int len;
    private static char[] number;
    private static long[] dp;
    private static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        // 초기 세팅
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        if (number[1] == '0') {
            System.out.println(0);
            return;
        }

        for (int i = 2; i <= len; i++) {
            int num1 = Integer.parseInt(String.valueOf(number[i]));
            int num2 = Integer.parseInt(String.valueOf(number[i - 1]) + String.valueOf(number[i]));

            if (num1 >= 1 && num1 <= 9) {
                dp[i] += dp[i - 1] % MOD;
            }

            if (num2 >= 10 && num2 <= 26) {
                dp[i] += dp[i - 2] % MOD;
            }
        }

        System.out.println(dp[len] % MOD);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        len = N.length();

        dp = new long[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        number = new char[len + 1];


        for(int i = 1; i <= len; i++){
            number[i] = N.charAt(i - 1);
        }
    }
}
