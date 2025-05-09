package boj.dp.내리막길_1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int M, N;
    private static int[][] board, dp;
    private static int[] dr = new int[]{1, 0, -1, 0};
    private static int[] dc = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        // 초기화
        init();
        // 풀이과정
        solve();
    }

    private static void solve() {
        System.out.println(go(M - 1, N - 1));
    }

    private static int go(int r, int c) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isInBoard(nr, nc) && board[nr][nc] > board[r][c]) {
                sum += go(nr, nc);
            }
        }

        dp[r][c] = sum;

        return sum;
    }

    private static boolean isInBoard(int r, int c) {
        if (r < 0 || c < 0 || r >= M || c >= N) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[M][N];
        dp = new int[M][N];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        dp[0][0] = 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
