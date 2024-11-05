package boj.시뮬레이션.Easy2048_12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int ans;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        play(0);

        System.out.println(ans);
    }

    private static void play(int depth) {
        if (depth == 5) {
            getResult(board);
            return;
        }

        int[][] origin = new int[N][N];
        for (int i = 0; i < N; i++) {
            origin[i] = board[i].clone();
        }

        for (int dir = 0; dir < 4; dir++) {
            move(dir, board);
            play(depth + 1);

            for (int i = 0; i < N; i++) {
                board[i] = origin[i].clone();
            }
        }
    }

    private static void move(int dir, int[][] board) {
        visited = new boolean[N][N];
        if (dir == 0) {
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    if (board[i][j] != 0) {
                        int num = board[i][j];
                        Pos go = go(i, j, dir, board);
                        board[i][j] = 0;
                        board[go.r][go.c] += num;
                    }
                }
            }
        } else if (dir == 1) {
            for (int j = 0; j < N; j++) {
                for (int i = N - 1; i >= 0; i--) {
                    if (board[i][j] != 0) {
                        int num = board[i][j];
                        Pos go = go(i, j, dir, board);
                        board[i][j] = 0;
                        board[go.r][go.c] += num;
                    }
                }
            }
        } else if (dir == 2) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] != 0) {
                        int num = board[i][j];
                        Pos go = go(i, j, dir, board);
                        board[i][j] = 0;
                        board[go.r][go.c] += num;
                    }
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    if (board[i][j] != 0) {
                        int num = board[i][j];
                        Pos go = go(i, j, dir, board);
                        board[i][j] = 0;
                        board[go.r][go.c] += num;
                    }
                }
            }
        }
    }

    private static Pos go(int i, int j, int dir, int[][] board) {
        Pos p = new Pos(i, j);
        int r = i;
        int c = j;
        while (true) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N || (board[nr][nc] != 0 && board[i][j] != board[nr][nc])) {
                p = new Pos(r, c);
                break;
            }

            if (board[i][j] == board[nr][nc]) {
                if (visited[nr][nc]) {
                    p = new Pos(r, c);
                    break;
                } else {
                    visited[nr][nc] = true;
                }
            }

            r = nr;
            c = nc;
        }

        return p;
    }

    private static void getResult(int[][] board) {
        for (int[] num : board) {
            for (int n : num) {
                if (n > ans) {
                    ans = n;
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
