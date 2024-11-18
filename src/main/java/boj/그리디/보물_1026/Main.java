package boj.그리디.보물_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int ans;
    static int[] A;
    static int[] B;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            int cur = A[i] * B[N - 1 - i];
            ans += cur;
        }

        System.out.println(ans);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        ans = 0;
        A = new int[N];
        B = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            B[j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);
    }
}
