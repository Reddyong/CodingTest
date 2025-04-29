package boj.무작위.주사위굴리기_14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int r;
    private static int c;
    private static int K;
    private static int[] moving;
    private static int[][] board;
    private static int[] cur;
    private static int[] dr = new int[]{0, 0, -1, 1};
    private static int[] dc = new int[]{1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        Dice curDice = new Dice(0, 5, 1, 4, 3, 2);

        for (int move : moving) {
            int top = curDice.top;
            int bottom = curDice.bottom;
            int up = curDice.up;
            int down = curDice.down;
            int left = curDice.left;
            int right = curDice.right;

            Dice nextDice;

            if (move == 1) {
                // 동
                move = 0;
                nextDice = new Dice(right, left, up, down, top, bottom);
            } else if (move == 2) {
                // 서
                move = 1;
                nextDice = new Dice(left, right, up, down, bottom, top);
            } else if (move == 3) {
                // 북
                move = 2;
                nextDice = new Dice(down, up, top, bottom, left, right);
            } else {
                // 남
                move = 3;
                nextDice = new Dice(up, down, bottom, top, left, right);
            }

            int nr = r + dr[move];
            int nc = c + dc[move];

            if (!isInBoard(nr, nc)){
                continue;
            }

            curDice = nextDice;
            r = nr;
            c = nc;

            if (board[r][c] == 0) {
                board[r][c] = cur[curDice.bottom];
            } else {
                cur[curDice.bottom] = board[r][c];
                board[r][c] = 0;
            }

            System.out.println(cur[curDice.top]);

        }
    }

    private static boolean isInBoard(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= M) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        moving = new int[K];
        cur = new int[6];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            moving[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static class Dice {
        int top;
        int bottom;
        int up;
        int down;
        int left;
        int right;

        public Dice(int top, int bottom, int up, int down, int left, int right) {
            this.top = top;
            this.bottom = bottom;
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
        }
    }
}
