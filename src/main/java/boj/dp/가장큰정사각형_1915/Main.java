package boj.dp.가장큰정사각형_1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, answer;
    private static int[][] board, dp;
    public static void main(String[] args) throws IOException {
        // 보드판, dp 배열 초기화
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        // dp[i][j] 가 의미하는 것
        // i, j를 오른쪽 하단 모서리라고 가정할 때, 이 지점을 가지는 정사각형 중 최대 한변의 길이
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                // 왼쪽, 위, 왼쪽위 대각선을 탐색하여 가장 작은 정사각형의 한변의 길이 탐색
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + board[i][j];

                // 넓이 최댓값으로 업데이트
                answer = Math.max(answer, dp[i][j] * dp[i][j]);
            }
        }

        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;

        board = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(split[j]);

                if (i == 0 || j == 0) {
                    dp[i][j] = board[i][j];
                    // 높이나 너비가 1인 경우도 있기 때문에, 정답값 업데이트
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
    }
}
