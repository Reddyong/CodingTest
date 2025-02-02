package softeer.dp.바이러스;

import java.io.*;
import java.util.*;

public class Main {
    private static int K;
    private static int P;
    private static int N;
    private static long[] dp;
    private static final int MOD_VALUE = 1000000007;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve(){
        for(int i = 1; i < dp.length; i++){
            dp[i] = ((dp[i - 1] % MOD_VALUE) * (P % MOD_VALUE)) % MOD_VALUE;
        }

        System.out.println(dp[N] % MOD_VALUE);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new long[N + 1];
        dp[0] = K;
    }
}