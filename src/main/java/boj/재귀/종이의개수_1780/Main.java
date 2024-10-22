package boj.재귀.종이의개수_1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int minusOne;
    static int zero;
    static int plusOne;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {

        recur(N, 0, 0);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);
    }

    private static void recur(int n, int r, int c) {

        if (n == 1 || isAllSameNumber(n, r, c)) {
            if (board[r][c] == -1) {
                minusOne++;
            } else if (board[r][c] == 0) {
                zero++;
            } else {
                plusOne++;
            }

            return;
        }

        for (int i = r; i < r + n; i += (n / 3)) {
            for (int j = c; j < c + n; j += (n / 3)) {
                recur(n / 3, i, j);
            }
        }
    }

    private static boolean isAllSameNumber(int n, int r, int c) {
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
        minusOne = 0;
        zero = 0;
        plusOne = 0;

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
