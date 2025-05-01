package boj.dp.무한수열_1351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static Long N, P, Q;
    private static Map<Long, Long> dp;
    public static void main(String[] args) throws IOException {
        // 초기화
        init();
        // 풀이과정
        solve();
    }

    private static void solve() {
        // top-down DP 알고리즘
        long answer = getResult(N);
        System.out.println(answer);
    }

    private static long getResult(long idx) {
        if (dp.containsKey(idx)) {
            return dp.get(idx);
        }

        dp.put(idx, getResult(idx / P) + getResult(idx / Q));

        return dp.get(idx);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        dp = new HashMap<>();
        dp.put(0L, 1L);
    }
}
