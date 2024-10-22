package boj.재귀.쿼드트리_1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        System.out.println(recur(N, 0, 0));
    }

    private static String recur(int n, int r, int c) {

        if (n == 1 || isAllSameNum(n, r, c)) {
            return String.valueOf(board[r][c]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = r; i < r + n; i += (n / 2)) {
            for (int j = c; j < c + n; j += (n / 2)) {
                sb.append(recur(n / 2, i, j));
            }
        }
        sb.append(")");

        return String.valueOf(sb);
    }

    private static boolean isAllSameNum(int n, int r, int c) {
        int start = board[r][c];

        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (board[i][j] != start) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
