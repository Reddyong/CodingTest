package boj.dp.ACMCraft_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int T, N, K, W;
    private static int[] D, dp;
    private static List<List<Integer>> map;
    public static void main(String[] args) throws IOException {
        // 풀이과정
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            // 초기화 과정
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            D = new int[N + 1];
            dp = new int[N + 1];
            Arrays.fill(dp, -1);

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }

            map = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                map.add(new ArrayList<>());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                map.get(to).add(from);
            }

            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());

            System.out.println(acm(W));
        }
    }

    private static int acm(int cur) {
        if (dp[cur] != -1) {
            return dp[cur];
        }

        dp[cur] = 0;
        for (int next : map.get(cur)) {
            dp[cur] = Math.max(dp[cur], acm(next));
        }

        return dp[cur] = dp[cur] + D[cur];
    }
}
