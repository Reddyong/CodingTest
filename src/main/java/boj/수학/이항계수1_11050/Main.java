package boj.수학.이항계수1_11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        int permutation = getFactorial(N) / getFactorial(N - K);
        int combination = permutation / getFactorial(K);

        System.out.println(combination);
    }

    private static int getFactorial(int n) {
        int ans = 1;

        for (int i = 1; i <= n; i++) {
            ans *= i;
        }

        return ans;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}
