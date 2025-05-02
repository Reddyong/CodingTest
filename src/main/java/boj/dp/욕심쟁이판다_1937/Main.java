package boj.dp.욕심쟁이판다_1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, answer;
    private static int[][] board, dp;
    private static int[] dr = new int[]{1, 0, -1, 0};
    private static int[] dc = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        // 초기화
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, panda(i, j));
            }
        }

        System.out.println(answer);
    }

    private static int panda(int r, int c) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isInBoard(nr, nc) && board[nr][nc] > board[r][c]) {
                dp[r][c] = Math.max(dp[r][c], panda(nr, nc) + 1);
            }
        }

        return dp[r][c];
    }

    private static boolean isInBoard(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= N) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        dp = new int[N][N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
    }
}
