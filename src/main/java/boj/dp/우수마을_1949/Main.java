package boj.dp.우수마을_1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] people;
    private static List<List<Integer>> village;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        // dp 배열 및 마을 인접리스트 초기화
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        // 1번 마을부터 시작
        dfs(1, 0);

        // 정답 출력
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void dfs(int cur, int prev) {
        // dp[i][0] : i번 마을을 우수마을로 선정할 때, i번 마을의 서브트리에서의 최대 주민 수
        // dp[i][1] : i번 마을을 우수마을로 선정하지 않을 때, i번 마을의 서브트리에서의 최대 주민 수
        dp[cur][0] = people[cur];
        dp[cur][1] = 0;

        for (int next : village.get(cur)) {
            if (next == prev) {
                continue;
            }

            dfs(next, cur);
            // 인접하여 우수마을 일 수 없으므로, 자식이 일반 마을인 경우 더함
            dp[cur][0] += dp[next][1];
            // 현재 마을이 우수마을이 아니므로, 자식이 우수마을, 일반마을인 경우 중 최댓값 더함
            dp[cur][1] += Math.max(dp[next][0], dp[next][1]);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        people = new int[N + 1];
        dp = new int[N + 1][2];
        village = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            village.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            village.get(from).add(to);
            village.get(to).add(from);
        }
    }
}
