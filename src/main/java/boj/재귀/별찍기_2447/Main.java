package boj.재귀.별찍기_2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static String[][] board;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        star(N, 0, 0);

        StringBuilder sb = new StringBuilder();

        for (String[] b : board) {
            for (String cur : b) {
                sb.append(cur);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void star(int n, int r, int c) {

        if (n == 1) {
            board[r][c] = "*";
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }

                star(n / 3, r + i * n / 3, c + j * n / 3);
            }
        }

    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new String[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], " ");
        }
    }
}
