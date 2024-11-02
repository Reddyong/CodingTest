package autoever.하반기_2410.n2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int L;
    static int T;
    static int ans;
    static int[][] board;
    static int[] dr;
    static int[] dc;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        ans = dfs();

        System.out.println(ans);
    }

    private static int dfs() {
        int max = 0;
        Stack<Pos> stack = new Stack<>();
        if (board[0][0] == -1) {
            T--;

            if (T < 0) {
                return -1;
            }
        }

        stack.push(new Pos(0, 0, T, board[0][0]));

        while (!stack.isEmpty()) {
            Pos pop = stack.pop();

            if (pop.r == N * M - 1 && pop.c == L - 1) {
                if (max < pop.sum) {
                    max = pop.sum;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (pop.r % N == N - 1 && i == 0) {
                    continue;
                }

                int nr = pop.r + dr[i];
                int nc = pop.c + dc[i];

                if (isInBoard(nr, nc)) {
                    if (pop.remainT > 0 && board[nr][nc] == -1) {
                        stack.push(new Pos(nr, nc, pop.remainT - 1, pop.sum));
                    }

                    if (board[nr][nc] != -1) {
                        stack.push(new Pos(nr, nc, pop.remainT, pop.sum + board[nr][nc]));
                    }
                }
            }
        }

        return max;
    }

    private static boolean isInBoard(int r, int c) {
        if (r < 0 || c < 0 || r >= N * M || c >= L) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[N * M][L];
        dr = new int[]{1, 0, N};
        dc = new int[]{0, 1, 0};

        for (int i = 0; i < N * M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < L; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static class Pos{
        int r;
        int c;
        int remainT;
        int sum;

        public Pos(int r, int c, int remainT, int sum) {
            this.r = r;
            this.c = c;
            this.remainT = remainT;
            this.sum = sum;
        }
    }
}
