package softeer.재귀.함께하는효도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int ans;
    static int[][] board;
    static int[][] friends;
    static boolean[][] visited;
    static int[] dr = new int[]{1, 0, -1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        int r = friends[0][0];
        int c = friends[0][1];

        hyodo(r, c, 0, 0, 1, board[r][c]);

        System.out.println(ans);
    }

    private static void hyodo(int r, int c, int idx, int count, int depth, int sum) {
        if (count == 3) {
            if (depth == m) {
                if (ans < sum) {
                    ans = sum;
                }
                return;
            }

            int nr = friends[idx + 1][0];
            int nc = friends[idx + 1][1];

            hyodo(nr, nc, idx + 1, 0, depth + 1, sum + board[nr][nc]);

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isInBoard(nr, nc) && !visited[nr][nc]) {
                visited[nr][nc] = true;
                hyodo(nr, nc, idx, count + 1, depth, sum + board[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }

    private static boolean isInBoard(int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 0;
        board = new int[n][n];
        visited = new boolean[n][n];
        friends = new int[m][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            for (int l = 0; l < 2; l++) {
                friends[k][l] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        for (int[] friend : friends) {
            int r = friend[0];
            int c = friend[1];

            visited[r][c] = true;
        }
    }
}
