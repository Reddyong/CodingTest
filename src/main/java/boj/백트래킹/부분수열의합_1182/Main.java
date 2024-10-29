package boj.백트래킹.부분수열의합_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int ans;
    static boolean[] visited;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        recur(0, 0);

        if (S == 0) {
            ans--;
        }

        System.out.println(ans);
    }

    private static void recur(int cur, int sum) {
        if (cur == N) {
            if (sum == S) {
                ans++;
            }
            return;
        }

        recur(cur + 1, sum);
        recur(cur + 1, sum + nums[cur]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = 0;
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
