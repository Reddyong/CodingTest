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
    static int[][] calendar;
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

            calendar = new int[M + 1][lcm / M];

            makeCalendar(lcm);

            int ans = getResult(lcm);

            arr[i] = ans;

        }


        for (int num : arr) {
            System.out.println(num);
        }
    }

    private static int getResult(int lcm) {
        for (int i = 0; i < lcm / M; i++) {
            if (calendar[x][i] == y) {
                return M * i + x;
            }
        }

        return -1;
    }

    private static void makeCalendar(int lcm) {
        int c = 0;
        for (int i = 1; i <= lcm; i++) {
            int r = i % M;
            int num = i % N;

            if (r == 0) {
                r = M;
            }

            if (num == 0) {
                num = N;
            }

            if (i % M == 1 && i != 1) {
                c++;
            }

            calendar[r][c] = num;

        }
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
