package boj.재귀.Z_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        int answer = Z(N, r, c);
        System.out.println(answer);
    }

    private static int Z(int n, int r, int c) {
        int half = (int) Math.pow(2, n - 1);

        if (n == 0) {
            return 0;
        }

        if (r < half && c < half) {
            return Z(n - 1, r, c);
        } else if (r < half && c >= half) {
            return half * half + Z(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * half * half + Z(n - 1, r - half, c);
        } else {
            return 3 * half * half + Z(n - 1, r - half, c - half);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }
}
