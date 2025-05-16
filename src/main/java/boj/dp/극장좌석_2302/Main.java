package boj.dp.극장좌석_2302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N, M;
    private static int[] dp, vip;
    public static void main(String[] args) throws IOException {
        // 초기화
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        // dp 배열 채우기
        // dp[i] = i개의 연속된 좌석에서 가능한 좌석 배치 수
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 좌석 경우의 수 구하기
        long answer = 1;
        int cur = 0;
        for (int i = 1; i < vip.length; i++) {
            int gap = vip[i] - cur - 1;
            answer *= dp[gap];

            cur = vip[i];
        }

        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        vip = new int[M + 2];
        vip[0] = 0;
        vip[M + 1] = N + 1;

        for (int i = 1; i <= M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        dp[1] = 1;
        if (N >= 2) {
            dp[2] = 2;
        }
    }
}
