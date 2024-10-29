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
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            recur(i, nums[i]);
        }

        System.out.println(ans);
    }

    private static void recur(int start, int sum) {
        if (sum == S) {
            ans++;
        }

        for (int i = start + 1; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                recur(i, sum + nums[i]);
                visited[i] = false;
            }
        }
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
