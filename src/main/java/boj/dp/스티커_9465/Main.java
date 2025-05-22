package boj.dp.스티커_9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, T;
    private static int[][] dp, arr;
    public static void main(String[] args) throws IOException {
        // 풀이 과정
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N + 1][2];
            arr = new int[N + 1][2];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            // dp 배열 채우기
            fillArr();

            System.out.println(Math.max(dp[N][0], dp[N][1]));
        }
    }

    private static void fillArr() {
        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + arr[i][0], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + arr[i][1], dp[i - 1][1]);
        }
    }
}
