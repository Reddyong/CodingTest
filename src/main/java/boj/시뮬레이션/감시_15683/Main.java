package boj.시뮬레이션.감시_15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int ans;
    static int[][] board1;
    static List<CCTV> cctvList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        cctv(0, board1);

        System.out.println(ans);
    }

    private static void cctv(int depth, int[][] board) {
        if (depth == cctvList.size()) {
            ans = Math.min(ans, getZeroNum(board));
            return;
        }

        int r = cctvList.get(depth).r;
        int c = cctvList.get(depth).c;
        int cctv = cctvList.get(depth).cctvNum;
        int[][] board2;

        if (cctv == 1) {
            for (int i = 0; i < 4; i++) {
                board2 = copyBoard(board);
                checkDir(i, r, c, board2);
                cctv(depth + 1, board2);
            }

        } else if (cctv == 2) {
            for (int i = 0; i < 2; i++) {
                board2 = copyBoard(board);
                checkDir(i, r, c, board2);
                checkDir((i + 2) % 4, r, c, board2);
                cctv(depth + 1, board2);
            }
        } else if (cctv == 3) {
            for (int i = 0; i < 4; i++) {
                board2 = copyBoard(board);
                checkDir(i, r, c, board2);
                checkDir((i + 1) % 4, r, c, board2);
                cctv(depth + 1, board2);
            }
        } else if (cctv == 4) {
            for (int i = 0; i < 4; i++) {
                board2 = copyBoard(board);
                checkDir(i, r, c, board2);
                checkDir((i + 1) % 4, r, c, board2);
                checkDir((i + 3) % 4, r, c, board2);
                cctv(depth + 1, board2);
            }
        } else {
            board2 = copyBoard(board);
            checkDir(0, r, c, board2);
            checkDir(1, r, c, board2);
            checkDir(2, r, c, board2);
            checkDir(3, r, c, board2);
            cctv(depth + 1, board2);
        }
    }

    private static int getZeroNum(int[][] board) {
        int tmp = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    tmp++;
                }
            }
        }

        return tmp;
    }

    private static void checkDir(int dir, int r, int c, int[][] board2) {
        if (dir == 0) { // 북
            for (int i = r - 1; i >= 0; i--) {
                if (board2[i][c] == 6) {
                    return;
                }

                if (board2[i][c] != 0) {
                    continue;
                }

                board2[i][c] = -1;
            }
        } else if (dir == 1) {  // 동
            for (int j = c + 1; j < M; j++) {
                if (board2[r][j] == 6) {
                    return;
                }

                if (board2[r][j] != 0) {
                    continue;
                }

                board2[r][j] = -1;
            }
        } else if (dir == 2) {  // 남
            for (int i = r + 1; i < N; i++) {
                if (board2[i][c] == 6) {
                    return;
                }

                if (board2[i][c] != 0) {
                    continue;
                }

                board2[i][c] = -1;
            }
        } else {    // 서
            for (int j = c - 1; j >= 0; j--) {
                if (board2[r][j] == 6) {
                    return;
                }

                if (board2[r][j] != 0) {
                    continue;
                }

                board2[r][j] = -1;
            }
        }
    }

    private static int[][] copyBoard(int[][] board) {
        int[][] board2 = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board2[i][j] = board[i][j];
            }
        }

        return board2;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        board1 = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board1[i][j] = Integer.parseInt(st.nextToken());

                if (board1[i][j] != 0 && board1[i][j] != 6) {
                    cctvList.add(new CCTV(i, j, board1[i][j]));
                }
            }
        }
    }

    private static class CCTV {
        int r;
        int c;
        int cctvNum;

        public CCTV(int r, int c, int cctvNum) {
            this.r = r;
            this.c = c;
            this.cctvNum = cctvNum;
        }
    }
}
