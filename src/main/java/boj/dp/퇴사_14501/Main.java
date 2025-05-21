package boj.dp.퇴사_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, answer;
    private static int[] T, P, dp;
    public static void main(String[] args) throws IOException {
        // 초기화
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        answer = 0;
        // dp 배열 채우기
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, go(i));
        }
        System.out.println(answer);
    }

    private static int go(int idx) {
        if (dp[idx] != -1) {
            return dp[idx];
        }

        if (idx + T[idx] > N) {
            if (idx + T[idx] == N + 1) {
                dp[idx] = P[idx];
            } else {
                dp[idx] = 0;
            }
            return dp[idx];
        }

        dp[idx] = P[idx];
        int max = 0;
        for (int i = idx + T[idx]; i <= N; i++) {
            dp[i] = Math.max(dp[i], go(i));
            max = Math.max(max, dp[i]);
        }

        dp[idx] += max;

        return dp[idx];
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = new int[N + 1];
        P = new int[N + 1];
        dp = new int[N + 1];
        Arrays.fill(dp, -1);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
    }
}
