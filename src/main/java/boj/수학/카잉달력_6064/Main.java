package boj.수학.카잉달력_6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int M;
    static int N;
    static int x;
    static int y;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        arr = new int[T];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int lcm = getLCM(M, N);

            int ans = getResult(lcm);

            arr[i] = ans;

        }


        for (int num : arr) {
            System.out.println(num);
        }
    }

    private static int getResult(int lcm) {
        for (int i = x; i <= lcm; i += M) {
            int mod1 = i % M;
            int mod2 = i % N;

            if (mod1 == 0) {
                mod1 = M;
            }

            if (mod2 == 0) {
                mod2 = N;
            }

            if (mod1 == x && mod2 == y) {
                return i;
            }
        }

        return -1;
    }

    private static int getLCM(int M, int N) {
        return M / getGCD(M, N) * N;
    }

    private static int getGCD(int M, int N) {
        if (N == 0) {
            return M;
        }

        return getGCD(N, M % N);
    }
}
