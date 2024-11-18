package boj.그리디.평범한배낭_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int ans;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        recur(0, 0, 0);

        System.out.println(ans);
    }

    private static void recur(int idx, int cur, int weight) {
        if (weight > K) {
            ans = Math.max(ans, cur - arr[idx - 1][1]);
            return;
        }

        if (idx == N) {
            ans = Math.max(ans, cur);
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                recur(i + 1, cur + arr[i][1], weight + arr[i][0]);
                visited[i] = false;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        visited = new boolean[N];
        ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
