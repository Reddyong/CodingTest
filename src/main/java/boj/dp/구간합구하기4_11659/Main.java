package boj.dp.구간합구하기4_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] nums;
    static int[][] sumNums;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        fillDP();

        for (int[] sumNum : sumNums) {
            int r = sumNum[0];
            int c = sumNum[1];
            int ans = dp[c] - dp[r - 1];
            System.out.println(ans);
        }
    }

    private static void fillDP() {
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        sumNums = new int[M][2];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sumNums[i][0] = Integer.parseInt(st.nextToken());
            sumNums[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
