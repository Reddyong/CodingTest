package boj.투포인터.부분합_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int S;
    private static int sum;
    private static int min;
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        //5 1 3 5 10 7 4 9 2 8
        int j = 0;
        for (int i = 0; i < N; i++) {
            while (j < N) {
                if (sum < S) {
                    j++;
                    if (j != N) {
                        sum += nums[j];
                    }
                } else {
                    sum -= nums[i];
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }

        System.out.println(min);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        sum = 0;
        min = Integer.MAX_VALUE;
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        sum = nums[0];
    }
}
