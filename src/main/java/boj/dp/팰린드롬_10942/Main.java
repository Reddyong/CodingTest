package boj.dp.팰린드롬_10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static int[][] dp, question;
    public static void main(String[] args) throws IOException {
        // dp 배열 및 변수 초기화
        init();
        solve();
    }

    private static void solve() {
        // dp 배열 채우기
        for (int len = 1; len <= N; len++) {
            for (int start = 1; start + len - 1 <= N; start++) {
                int end = start + len - 1;

                if (start == end) {
                    dp[start][end] = 1;
                    continue;
                }

                if (arr[start] == arr[end]) {
                    if (len == 2) {
                        dp[start][end] = 1;
                    } else {
                        dp[start][end] = dp[start + 1][end - 1];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] q : question) {
            sb.append(dp[q[0]][q[1]]).append("\n");
        }

        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        question = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            question[i][0] = Integer.parseInt(st.nextToken());
            question[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
