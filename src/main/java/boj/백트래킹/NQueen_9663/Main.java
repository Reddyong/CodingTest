package boj.백트래킹.NQueen_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int ans;
    static boolean[] visited1;
    static boolean[] visited2;
    static boolean[] visited3;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        recur(0);

        System.out.println(ans);
    }

    private static void recur(int depth) {
        if (depth == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited1[i] && !visited2[depth + i] && !visited3[depth - i + N - 1]) {
                visited1[i] = true;
                visited2[depth + i] = true;
                visited3[depth - i + N - 1] = true;
                recur(depth + 1);
                visited1[i] = false;
                visited2[depth + i] = false;
                visited3[depth - i + N - 1] = false;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited1 = new boolean[N];
        visited2 = new boolean[N * 2];
        visited3 = new boolean[N * 2];
        ans = 0;
    }
}
