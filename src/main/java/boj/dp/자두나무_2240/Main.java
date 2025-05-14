package boj.dp.자두나무_2240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int T, W;
    private static int[][][] dp;
    private static int[] location;
    public static void main(String[] args) throws IOException {
        // 초기화
        init();
        // 풀이과정
        solve();

    }

    private static void solve() {
        // dp 배열 채우기
        // dp[i][j][k] : 현재 k번 나무에 있을 때, j번 움직인 경우의 i초 시점에서 수확하는 최대 자두 갯수
        for (int i = 1; i <= T; i++) {
            // 자두는 1번 나무에서 출발하므로, 움직이지 않는 경우는 2번 나무로 갈 수 없다.
            if (location[i] == 1){
                dp[i][0][1] = dp[i - 1][0][1] + 1;
            }

            for (int j = 1; j <= W; j++) {
                if (location[i] == 1) {
                    // 자두가 떨어지는 나무가 1번 나무인 경우
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]);
                } else {
                    // 자두가 떨어지는 나무가 2번 나무인 경우
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]) + 1;
                }
            }
        }

        // 자두의 최댓값 구하기
        int max = 0;
        for (int i = 1; i <= T; i++) {
            for (int j = 0; j <= W; j++) {
                max = Math.max(dp[i][j][1], dp[i][j][2]);
            }
        }

        System.out.println(max);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        dp = new int[T + 1][W + 1][3];
        location = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            location[i] = Integer.parseInt(st.nextToken());
        }
    }
}
