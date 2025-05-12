package boj.dp.RGB트리_27501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, answer;
    private static String result;
    private static List<List<Integer>> list;
    private static int[][] lights, dp;
    private static String[] route;
    public static void main(String[] args) throws IOException {
        // 초기화
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        // 최대 아름다움 값 구하기
        dfs(1, 0);

        answer = Math.max(dp[1][0], Math.max(dp[1][1], dp[1][2]));

        int maxIdx = findMaxIdx(1, -1);
        find(1, 0, maxIdx);

        result = getResult();

        System.out.println(answer);
        System.out.println(result);
    }

    private static int findMaxIdx(int cur, int prevMaxIdx) {
        int max = 0;
        int idx = -1;
        for (int i = 0; i < 3; i++) {
            if (i == prevMaxIdx) {
                continue;
            }

            if (dp[cur][i] > max) {
                max = dp[cur][i];
                idx = i;
            }
        }

        return idx;
    }

    private static void find(int cur, int prev, int maxIdx){
        route[cur] = findMaxLight(maxIdx);

        for (int next : list.get(cur)) {
            if (next == prev) {
                continue;
            }

            int m = findMaxIdx(next, maxIdx);
            find(next, cur, m);
        }
    }

    private static String getResult() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(route[i]);
        }

        return sb.toString();
    }

    private static void dfs(int cur, int prev) {
        dp[cur][0] = lights[cur][0];
        dp[cur][1] = lights[cur][1];
        dp[cur][2] = lights[cur][2];

        for (int next : list.get(cur)) {
            if (next == prev) {
                continue;
            }

            dfs(next, cur);

            dp[cur][0] += Math.max(dp[next][1], dp[next][2]);
            dp[cur][1] += Math.max(dp[next][0], dp[next][2]);
            dp[cur][2] += Math.max(dp[next][0], dp[next][1]);

        }

    }

    private static String findMaxLight(int idx) {
        if (idx == 0) {
            return "R";
        } else if (idx == 1) {
            return "G";
        } else {
            return "B";
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        lights = new int[N + 1][3];
        dp = new int[N + 1][3];
        route = new String[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
            list.get(to).add(from);
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lights[i][0] = r;
            lights[i][1] = g;
            lights[i][2] = b;
        }
    }
}
