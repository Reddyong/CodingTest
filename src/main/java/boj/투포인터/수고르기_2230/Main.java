package boj.투포인터.수고르기_2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int min;
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        // 2 3 9 13 22
        int j = 0;
        for (int i = 0; i < N; i++) {
            while(j < N){
                int n1 = nums[i];
                int n2 = nums[j];

                if (n2 - n1 < M) {
                    j++;
                }else {
                    min = Math.min(min, n2 - n1);
                    break;
                }
            }
        }

        System.out.println(min);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        min = Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
    }
}
