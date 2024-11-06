package boj.정렬.카드_11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int N;
    static long ans;
    static long max;
    static Map<Long, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {

        System.out.println(ans);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        max = 0;

        for (int i = 0; i < N; i++) {
            long cur = Long.parseLong(br.readLine());

            map.put(cur, map.getOrDefault(cur, 0) + 1);

            if (map.get(cur) > max) {
                max = map.get(cur);
                ans = cur;
            } else if (map.get(cur) == max) {
                if (cur < ans) {
                    ans = cur;
                }
            }
        }
    }
}
