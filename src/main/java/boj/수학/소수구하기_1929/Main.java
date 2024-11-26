package boj.수학.소수구하기_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        makeEratostenes();

        for (int i = M; i <= N; i++) {
            if (check[i]) {
                System.out.println(i);
            }
        }
    }

    private static void makeEratostenes() {
        for (int i = 2; i * i <= N; i++) {
            if (!check[i]) {
                continue;
            }
            for (int j = i * i; j <= N; j += i) {
                check[j] = false;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        check = new boolean[N + 1];
        Arrays.fill(check, true);

        check[0] = false;
        check[1] = false;
    }
}
