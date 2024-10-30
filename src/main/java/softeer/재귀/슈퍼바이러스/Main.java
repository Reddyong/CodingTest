package softeer.재귀.슈퍼바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long K;
    static long P;
    static long N;
    static long ans;
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        ans = recur(N);

        System.out.println(ans * K % MOD);
    }

    private static long recur(long exponent) {
        if (exponent == 1) {
            return P % MOD;
        }

        long temp = recur(exponent / 2);
        temp = temp * temp % MOD;

        if (exponent % 2 == 1) {
            return temp * P % MOD;
        }

        return temp;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        N = Long.parseLong(st.nextToken()) * 10;
        ans = 0;
    }
}
