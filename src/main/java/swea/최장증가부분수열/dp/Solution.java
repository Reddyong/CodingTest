package swea.최장증가부분수열.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int T, N, answer;
    private static int[] arr;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int num = 1; num <= T; num++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            dp = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            getResult();
            print(num);
        }
    }

    private static void getResult() {
        answer = 0;

        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && max < dp[j]) {
                    max = dp[j];
                }
            }

            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }
    }

    private static void print(int num) {
        System.out.println("#" + num + " " + answer);
    }
}
