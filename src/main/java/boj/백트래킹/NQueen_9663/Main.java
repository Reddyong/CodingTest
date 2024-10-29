package boj.백트래킹.NQueen_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int ans;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            visited[0][i] = true;
            recur(0, i, 1);
            visited[0][i] = false;
        }

        System.out.println(ans);
    }

    private static void recur(int r, int c, int depth) {
        if (depth == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isPossibleQueen(r + 1, i)) {
                visited[r + 1][i] = true;
                recur(r + 1, i, depth + 1);
                visited[r + 1][i] = false;
            }
        }
    }

    private static boolean isPossibleQueen(int r, int c) {
        // 위 직선
        int nur = r;
        int nuc = c;
        while (isInBoard(nur, nuc)) {
            if (visited[nur][nuc]) {
                return false;
            }

            nur--;
        }

        // 왼쪽 위 대각선
        int nlr = r;
        int nlc = c;
        while (isInBoard(nlr, nlc)) {
            if (visited[nlr][nlc]) {
                return false;
            }

            nlr--;
            nlc--;
        }

        // 오른쪽 위 대각선
        int nrr = r;
        int nrc = c;
        while (isInBoard(nrr, nrc)) {
            if (visited[nrr][nrc]) {
                return false;
            }

            nrr--;
            nrc++;
        }

        return true;
    }

    private static boolean isInBoard(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= N) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        ans = 0;
    }
}
