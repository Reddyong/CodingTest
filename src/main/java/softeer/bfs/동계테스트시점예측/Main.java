package softeer.bfs.동계테스트시점예측;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans, time;
    static int[][] board, visited;
    static int[] dr = new int[]{1, 0, -1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(ans);
    }

    private static void solve() {
        while (true) {
            int count = 0;
            visited = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 1) {
                        count++;
                        bfs();
                    }
                }
            }

            if (count == 0) {
                ans = time;
                break;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] >= 2) {
                        board[i][j] = 0;
                    }
                }
            }

            time++;
        }
    }

    private static void bfs() {
        Queue<Pos> queue = new LinkedList<>();

        queue.add(new Pos(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Pos poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = poll.r + dr[i];
                int nc = poll.c + dc[i];

                if (!isInBoard(nr, nc)) {
                    continue;
                }

                if (board[nr][nc] == 1) {
                    visited[nr][nc]++;
                    continue;
                }

                if (board[nr][nc] == 0 && visited[nr][nc] == 0) {
                    visited[nr][nc] = 1;
                    queue.add(new Pos(nr, nc));
                }
            }
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

        ans = 0;
        time = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
